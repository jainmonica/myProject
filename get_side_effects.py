import os
import openai

openai.api_type = "azure"
openai.api_base = "https://americasopenai.azure-api.net"
# os.getenv("AZURE_OPENAI_ENDPOINT")
openai.api_version = "2023-05-15"
openai.api_key = "b3732cbbe3ae49978da159a1711b7d7a"
# os.getenv("AZURE_OPENAI_KEY")

def get_side_effects(medicine_name):
    response = openai.ChatCompletion.create(
        deployment_id="gpt-35-turbo-16k",
        messages=[
            {"role": "system", "content": "Assistant is a large language model trained by OpenAI."},
            {"role": "user", "content": f"what are the 4 common side effects of {medicine_name}, just provide the names"}
        ],
        temperature=0,
    )

    return response['choices'][0]['message']['content']
