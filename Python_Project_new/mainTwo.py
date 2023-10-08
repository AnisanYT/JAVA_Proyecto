import numpy as np
from datosEstadisticos import datosEstadisticos
vector = np.empty(0)
lista = [datosEstadisticos(nombre = "York", carrera = "ITI", periodoLectivo = "IC", Respuesta1 = "SI", Respuesta2 = "Excelente", dato1 = "Ok")]
vector = np.array(lista)

def function():
    print("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬")
    print("Bienvenido al formulario de evaluacion del docente.")
    print("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬")
    aplicacionForm()

def aplicacionForm():
    global vector
    nombre = input("Inserte el nombre del profesor: ")
    carrera = input("Inserte la carrera que pertenece: ")
    periodoLectivo = input("Inserte el periodo lectivo actual: ")
    Respuesta1 = input("¿Has asistido a todas las clases este semestre? SI o NO: ")
    Respuesta2 = input("¿Como califica ústed al profesor en la siguiente escala?\nExcelente, Muy bueno, Bueno, Regular, Malo, Muy malo: ")
    dato1 = input("¿Cuál es tu opinión sobre la calidad de las explicaciones proporcionadas por tu profesor en las clases? Por favor, describe tus observaciones y experiencias en detalle")
    lista = [datosEstadisticos(nombre = nombre, carrera = carrera, periodoLectivo = periodoLectivo, Respuesta1 = Respuesta1, Respuesta2 = Respuesta2, dato1 = dato1)]
    vector = np.append(vector, lista)
    #print(len(vector))
    for i in vector:
        print(i.get_nombre())
if __name__ == '__main__':
    function()