import os
from PIL import Image
import pytesseract
from pdf2image import convert_from_path


class PdfConverter:

    def __init__(self, file):
        self.pdf_file = file

    def convert(self):
        numPages = self.convertPdfToImage()
        self.proccessImages(numPages)

    def convertPdfToImage(self):
        pages = convert_from_path(self.pdf_file, 500)

        page_counter = 1

        if not os.path.exists('images'):
            os.makedirs('images')

        for page in pages:
            filename = "page_"+str(page_counter)+".jpg"
            page.save("images/"+filename, 'JPEG')
            page_counter = page_counter + 1

        return page_counter

    def proccessImages(self, filelimit):
        outfile = "out_text.txt"

        f = open(outfile, "a")

        for i in range(1, filelimit):
            filename = "images/page_"+str(i)+".jpg"

            # Recognize the text as string in image using pytesserct
            text = str(((pytesseract.image_to_string(Image.open(filename)))))

            # The recognized text is stored in variable text
            # Any string processing may be applied on text
            # Here, basic formatting has been done:
            # In many PDFs, at line ending, if a word can't
            # be written fully, a 'hyphen' is added.
            # The rest of the word is written in the next line
            # Eg: This is a sample text this word here GeeksF-
            # orGeeks is half on first line, remaining on next.
            # To remove this, we replace every '-\n' to ''.
            text = text.replace('-\n', '')

            f.write(text)
        f.close()
