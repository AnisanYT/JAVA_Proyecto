import openpyxl
import locale
locale.setlocale(locale.LC_ALL, "es")
import os
from docx import Document
import PyPDF2

# Declaracion

carpeta_origen = 'documentos/'
carpeta_destino = 'documentosFin/'

ruta_1 = r'documentos/'
ruta_2 = r'documentosFin/'

os.chdir(ruta_1)

total_documentos = 0  # Todos los documentos
correctos = 0  # Los que no tuvieron error
con_error = 0  # Los que tuvieron error

excel_fn = 'documentos/informacionWeb.xlsx'
if not os.path.exists(excel_fn.xlsx):
    workbook = openpyxl.Workbook()
    workbook.save(excel_fn.xlsx)
else:
    workbook = openpyxl.load_workbook(excel_fn.xlsx)

    sheet = workbook.active  #hoja para guardar datos

for phat in ["pdf", "docx", "xlsx", "jpg", "jpeg", "png"]:
    ruta_1, extension = os.path.splitext(phat)
    try:
        if extension == "pdf":
            # Procesar archivos PDF
            pdf_reader = PyPDF2.PdfFileReader(open(ruta_1, "rb"))
            text = ""
            for page_num in range(pdf_reader.numPages):
                page = pdf_reader.getPage(page_num)
                text += page.extractText()
            sheet.append([phat, text]) # Registra los datos en el Excel

        elif extension == "docx":
            # Procesar archivos DOCX
            doc = Document(phat)
            text = ""
            for paragraph in doc.paragraphs:
                text += paragraph.text
            sheet.append([phat, text])  # Registra los datos en el Excel

        elif extension == "xlsx":
        # Procesar archivos Excel
            pass
        ##elif extension in ["jpg", "jpeg", "png"]:
        # Procesar imágenes
        ##total_documentos += 1

    except Exception as e:
        # Registra el error 
       con_error += 1
    total_documentos += 1

workbook.save(excel_fn)
# Resumen

print(f"Total de documentos procesados: {total_documentos}")
print(f"Archivos procesados correctamente: {correctos}")
print(f"Archivos que generaron error: {con_error}")

