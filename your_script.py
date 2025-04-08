import os
from google.cloud import language_v1

def analyze_sentiment(text_content, api_key):
    """
    Analyzes the sentiment of the provided text using the Google Cloud Natural Language API.

    Args:
        text_content: The text to analyze.
        api_key: Your Google Cloud API key.

    Returns:
        The sentiment score and magnitude.
    """
    os.environ['GOOGLE_API_KEY'] = api_key
    client = language_v1.LanguageServiceClient()

    document = language_v1.Document(
        content=text_content, type_=language_v1.Document.Type.PLAIN_TEXT
    )

    response = client.analyze_sentiment(request={'document': document})

    sentiment = response.document_sentiment
    print(f"Sentiment score: {sentiment.score}")
    print(f"Sentiment magnitude: {sentiment.magnitude}")

    return sentiment.score, sentiment.magnitude

if __name__ == "__main__":
    api_key = "YOUR_API_KEY"  # Replace with your actual API key
    user_input = input("Enter text to analyze: ")
    analyze_sentiment(user_input, api_key)
