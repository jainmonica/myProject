import os
import openai
# from azure.identity import DefaultAzureCredential
# from azure.keyvault.secrets import SecretClient

# vault_url = "https://hackathon2023-kv.vault.azure.net"
# credential = DefaultAzureCredential()
# client = SecretClient(vault_url=vault_url, credential=credential)
# secret_name = "openAI-api-key"
# secret_value = client.get_secret(secret_name).value
# print(f"The secret value is: {secret_value}")
openai.api_type = "azure"
openai.api_base = "https://americasopenai.azure-api.net"
# os.getenv("AZURE_OPENAI_ENDPOINT")
openai.api_version = "2023-05-15"
openai.api_key = 'b3732cbbe3ae49978da159a1711b7d7a'
# os.getenv("AZURE_OPENAI_KEY")

def get_medicine_ingredient(medicine_name):
    response = openai.ChatCompletion.create(
        deployment_id="gpt-35-turbo-16k",
        messages=[
            {"role": "system", "content": "Assistant is a large language model trained by OpenAI."},
            {"role": "user", "content": f"Please provide only primary ingredient for {medicine_name}. in 200 characters"}
        ],
        temperature=0,
    )
    generated_text = response['choices'][0]['message']['content']

    return generated_text
