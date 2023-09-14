import re

def extract_info(medication_text):
    # Regular expressions to match dosage and schedule patterns
    dosage_pattern = r'(\d+)\s*(?:tablet|pill|capsule|mg|g)?'  # Matches "2 tablets" or "2 mg"

    # Match a pattern for dosage that includes variations
    dosage_match = re.search(dosage_pattern, medication_text, re.IGNORECASE)

    # Initialize variables to store extracted information
    dosage = None
    schedule = None

    # Check if dosage pattern was found
    if dosage_match:
        dosage = dosage_match.group(1)  # Extract the dosage value

    # Extract schedule information using a more specific pattern
    schedule_pattern = r'every\s*(\d+(?:\s*to\s*\d+)?(?:\s*(?:hour|hr|minute|min|day|week|month)s?)?)'
    schedule_match = re.search(schedule_pattern, medication_text, re.IGNORECASE)

    # Check if schedule pattern was found
    if schedule_match:
        schedule = schedule_match.group(1)  # Extract the schedule value

    # Create a dictionary to hold the extracted information
    extracted_info = {
        'dosage': dosage,
        'schedule': schedule
    }

    return extracted_info