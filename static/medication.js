
   export function speakText() {
        const outputText = document.getElementById('outputText').value;
        const synth = window.speechSynthesis;
        const utterance = new SpeechSynthesisUtterance(outputText);
        synth.speak(utterance);

        const alertMessage = document.getElementById('alertMessage').textContent;
        if (alertMessage) {
            const alertUtterance = new SpeechSynthesisUtterance(alertMessage);
            synth.speak(alertUtterance);
        }
    }

    export async function processImage() {
        const imageUpload = document.getElementById('imageUpload');
        const outputText = document.getElementById('outputText');
    
        const file = imageUpload.files[0];
        if (file) {
            const formData = new FormData();
            formData.append('image', file);
    
            try {
                // Send the image to the server for text extraction
                const response = await fetch('/process_image', {
                    method: 'POST',
                    body: formData,
                });
    
                if (response.ok) {
                    const data = await response.json();
                    if (data.extracted_text && data['extracted_text']['Medicine Name']) {
                        // Display the extracted medicine information
                        const medicineInfo = data.extracted_text;
                        outputText.value = `Medicine Name: ${medicineInfo['Medicine Name']}\nMedicine Size: ${medicineInfo['Medicine Size']}\nMedicine Quantity: ${medicineInfo['Medicine Quantity']}\nMedicine Schedule: ${medicineInfo['Medicine Schedule']}`;
                    } else {
                        outputText.value = 'No medicine information extracted from the image.';
                    }
                    // Update the alert message div
                    const alertMessageDiv = document.getElementById('alertMessage');
                    alertMessageDiv.textContent = data.alert_message || '';
                    
                } else {
                    outputText.value = 'Error processing image.';
                }
            } catch (error) {
                console.error('Error processing image:', error);
                outputText.value = 'Error processing image.';
            }
        } else {
            outputText.value = 'Please select an image.';
        }
    }
    
  export async function callMedicationExtractApi() {
        const medicationText = document.getElementById('medicationText').value;
        const apiUrl = '/api/extract';  // Adjust the API endpoint as needed

        try {
            const response = await fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ medication_text: medicationText })
            });

            if (response.ok) {
                const data = await response.json();
                const outputDiv = document.getElementById('output');
                outputDiv.textContent = JSON.stringify(data, null, 2);
            } else {
                console.error('Error calling the API');
            }
        } catch (error) {
            console.error('Error calling the API:', error);
        }
    }
   export function callPredictSideEffects() {
        const medicationNameInput = document.getElementById("medicationName");
        const sideEffectsDiv = document.getElementById("sideEffects");
        
        const medicationName = medicationNameInput.value.trim();
        if (!medicationName) {
            alert("Please enter a medication name.");
            return;
        }
        
        const apiUrl = '/api/predict_side_effects'; // API endpoint
        
        fetch(apiUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ medication_name: medicationName }),
        })
        .then(response => response.json())
        .then(data => {
            if (data.predicted_side_effects) {
                const sideEffects = data.predicted_side_effects;
                sideEffectsDiv.textContent = `Predicted Side Effects: ${sideEffects}`;
            } else {
                sideEffectsDiv.textContent = "No side effects information available for this medication.";
            }
        })
        .catch(error => {
            console.error("Error predicting side effects:", error);
            sideEffectsDiv.textContent = "Error predicting side effects.";
        });
    }
   