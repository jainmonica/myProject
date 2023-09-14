from flask import Flask, render_template, request, jsonify
from azure_cognitive_service import extract_text_from_image
from extract_info import extract_info
from get_side_effects  import get_side_effects  # Import your Python method
# from get_ai_response import get_ai_response  # Import your Python method
from flask_cors import CORS
from flask_bootstrap import Bootstrap

app = Flask(__name__, static_url_path='/static')
app.config['DEBUG'] = True

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/process_image', methods=['POST'])
def process_image():
    try:
        print("Processing image request...")
        image_file = request.files['image']
        if image_file:
            extracted_text = extract_text_from_image(image_file)
            # Check if a medication name is mentioned in the extracted text
            if 'H20' in extracted_text:
                alert_message = "Reminder: Take your medication."
            else:
                alert_message = None
            print("Alert Message:", alert_message)  # Add this line for debugging

            return jsonify({'extracted_text': extracted_text, 'alert_message': alert_message})
        else:
            return jsonify({'error': 'No image file provided'})
    except Exception as e:
        print(f"Error processing image: {str(e)}")
        return jsonify({'error': str(e)})


@app.route('/api/extract', methods=['POST'])
def extract():
    try:
        medication_text = request.json.get('medication_text')
        if medication_text:
            extracted_info = extract_info(medication_text)
            return jsonify(extracted_info)
        else:
            return jsonify({'error': 'Medication text not provided'}), 400
    except Exception as e:
        return jsonify({'error': str(e)}), 500

@app.route('/api/predict_side_effects', methods=['POST'])
def predict_side_effects():
    try:
        data = request.get_json()
        medication_name = data.get('medication_name')
        
        # Perform side effect prediction based on medication_name
        predicted_side_effects = get_side_effects(medication_name)
        
        if predicted_side_effects:
            return jsonify({'predicted_side_effects': predicted_side_effects})
        else:
            return jsonify({'message': 'No side effects information available for this medication.'})
    except Exception as e:
        return jsonify({'error': str(e)})
    
# @app.route('/api/ai_chat_response', methods=['POST'])
# def ai_chat_response():
#     try:
#         data = request.get_json()
#         customer_question = data.get('customer_question')

#         # Get response from AI
#         ai_response = get_ai_response(customer_question)

#         if ai_response:
#             return jsonify({'ai_response': ai_response})
#         else:
#             return jsonify({'message': 'Sorry I am not about that'})

#     except Exception as e:
#         return jsonify({'error': str(e)})
    
if __name__ == '__main__':
     app.run()
