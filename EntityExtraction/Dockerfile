FROM python:3.7.3-slim

WORKDIR /opt/app

COPY requirements.txt /tmp/

RUN apt-get update && apt-get install -y \
    poppler-utils \
    tesseract-ocr
RUN pip install --upgrade pip
RUN python3 -m pip install --requirement /tmp/requirements.txt

COPY src /opt/app
COPY NightAngel.pdf /opt/app

CMD [ "python3",  "app.py"]