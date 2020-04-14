from pdfconverter import PdfConverter

import shutil
import os

# Path of the pdf
PDF_file = "NightAngel.pdf"


def cleanUp():
    if os.path.exists('images'):
        shutil.rmtree('images')

    if os.path.exists('out_text.txt'):
        os.remove('out_text.txt')


if __name__ == "__main__":
    cleanUp()
    reader = PdfConverter(PDF_file)
    reader.convert()
