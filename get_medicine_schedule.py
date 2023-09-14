import os
import openai

openai.api_type = "azure"
openai.api_base = "https://americasopenai.azure-api.net"
# os.getenv("AZURE_OPENAI_ENDPOINT")
openai.api_version = "2023-05-15"
openai.api_key = "b3732cbbe3ae49978da159a1711b7d7a"
# os.getenv("AZURE_OPENAI_KEY")

def get_medicine_schedule(medicine_name):
    response = openai.ChatCompletion.create(
        deployment_id="gpt-35-turbo-16k",
        messages=[
            {"role": "system", "content": "Assistant is a large language model trained by OpenAI."},
            {"role": "user", "content": f"Please provide the schedule for {medicine_name}. how often people with age 12 and above can take the {medicine_name} tablets in a day and in how many hours of gap. Also tell about the kids from 6 to 11 years old, all in  in  60 characters"}
        ],
        temperature=0,
    )
    generated_text = response['choices'][0]['message']['content']

    return generated_text
