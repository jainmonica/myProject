import requests
import re
from get_medicine_schedule import get_medicine_schedule 
from get_medicine_ingredient import get_medicine_ingredient

# from azure.identity import DefaultAzureCredential
# from azure.keyvault.secrets import SecretClient

# vault_url = "https://hackathon2023-kv.vault.azure.net"
# credential = DefaultAzureCredential()
# client = SecretClient(vault_url=vault_url, credential=credential)
# secret_name = "cognitive-service-sub-key1"
# secret_value = client.get_secret(secret_name).value
# print(f"The secret value is: {secret_value}")

subscription_key = '9e1d5f3cee9b4f43aa10bf62fa62a598'
endpoint = 'https://hackathon2023-cognitive-service.cognitiveservices.azure.com/'
# 'https://hackathon2023-cognitive-service.cognitiveservices.azure.com/'
# 'https://monica-demo-computer-vision.cognitiveservices.azure.com/'

# used cognitive service computer vision to extract the text from the image
def extract_text_from_image(image_file):
    url = f'{endpoint}/vision/v3.2/ocr?language=en'
    headers = {
        'Ocp-Apim-Subscription-Key': subscription_key,
    }
    response = requests.post(url, headers=headers, files={'image': (image_file.filename, image_file)})
    data = response.json()

    extracted_text = '\n'.join([
        ' '.join([word['text'] for word in line['words']])
        for region in data.get('regions', [])
        for line in region['lines']
    ])
    
    # Define regular expressions to extract medicine name, size, and quantity
    medicine_pattern = r'([A-Za-z\s]+)\n'  # Matches medicine name
    size_pattern = r'(\d+\s?(?:mg|g))'  # Matches size (e.g., "200 mg")
    quantity_pattern = r'(\d+)'  # Matches quantity (e.g., "300")

    # Extract medicine name, size, and quantity using regular expressions
    medicine_match = re.search(medicine_pattern, extracted_text)
    size_match = re.search(size_pattern, extracted_text)
    quantity_match = re.search(quantity_pattern, extracted_text)

    # Initialize variables to store extracted values
    medicine_name = medicine_match.group(1) if medicine_match else None
    medicine_size = size_match.group(1) if size_match else None
    medicine_quantity = quantity_match.group(1) if quantity_match else None

    # used prompt programming through Chat GPT to get the medicine schedule by passing medicine name 
    generated_text_schedule = get_medicine_schedule(medicine_name)

    # Set medicine_schedule based on whether it was generated or not
    if generated_text_schedule:
        medicine_schedule = generated_text_schedule
    else:
        medicine_schedule = None
    
    # used prompt programming through Chat GPT to get the medicine ingredients by passing medicine name 
    generated_text_ingredients = get_medicine_ingredient(medicine_name)

    # Set medicine_schedule based on whether it was generated or not
    if generated_text_ingredients:
        medicine_ingredients = generated_text_ingredients
    else:
        medicine_ingredients = None
        
    return {
        'Medicine Name': medicine_name,
        'Medicine Size': medicine_size,
        'Medicine Quantity': medicine_quantity,
        'Medicine Schedule': medicine_schedule,
        'Medicine Ingredients': medicine_ingredients,
        'Full Extracted Text': extracted_text  # Optionally, you can include the full extracted text
    }


