import numpy as np
from datosEstadisticos import datosEstadisticos
vector = np.empty(0)
lista = [datosEstadisticos(nombre = "York", carrera = "ITI", periodoLectivo = "IC", Respuesta1 = "SI", Respuesta2 = "Excelente", dato1 = "Ok")]
vector = np.array(lista)
lista = [datosEstadisticos(nombre = "York", carrera = "ITI", periodoLectivo = "IC", Respuesta1 = "SI", Respuesta2 = "Excelente", dato1 = "Ok")]
vector = np.append(vector, lista)
lista = [datosEstadisticos(nombre = "York", carrera = "ITI", periodoLectivo = "IC", Respuesta1 = "NO", Respuesta2 = "Muy bueno", dato1 = "Ok")]
vector = np.append(vector, lista)
lista = [datosEstadisticos(nombre = "York", carrera = "ITI", periodoLectivo = "IC", Respuesta1 = "SI", Respuesta2 = "Excelente", dato1 = "Ok")]
vector = np.append(vector, lista)
lista = [datosEstadisticos(nombre = "York", carrera = "ITI", periodoLectivo = "IC", Respuesta1 = "SI", Respuesta2 = "Bueno", dato1 = "Ok")]
vector = np.append(vector, lista)
lista = [datosEstadisticos(nombre = "Valery", carrera = "ITI", periodoLectivo = "IC", Respuesta1 = "SI", Respuesta2 = "Excelente", dato1 = "Ok")]
vector = np.append(vector, lista)

def function():
    print("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬")
    print("Bienvenido al formulario de evaluacion del docente.")
    print("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬")
    aplicacionForm()

def imprNombre():
    global vector
    auxConta = 0
    for i in vector: 
        if auxConta == 0:
            aux = i.get_nombre()
            auxConta += 1
            vectorNombres = np.array(aux)
        else:
            existe = np.any(i.get_nombre() == vectorNombres)
            if existe == False:
                vectorNombres = np.append(vectorNombres, i.get_nombre())
    auxContador = 0
    for i in vectorNombres:
        print("- ", i)
        auxContador += 1
    profesorsName = input("Escriba el nombre del profesor: ")
    return profesorsName

def calculo():
    #variables
    contador = 0
    contadorYes = 0
    contadorNo = 0

    #Variables
    varExcelente = 0
    varMuyBueno = 0
    varBueno = 0
    varRegular = 0
    varMalo = 0
    varMuyMalo = 0
    #Variables
    prExcelente = 0
    prMuyBueno = 0
    prBueno = 0
    prRegular = 0
    prMalo = 0
    prMuyMalo = 0
    prSI=0
    prNO=0
    print("Estos son los profesores disponibles para realizarle un calculo estadistico: ")
    nombreDeProfesor = imprNombre()
    for i in vector:
        if nombreDeProfesor == i.get_nombre():
            contador += 1
            if i.get_Respuesta1() == 'SI':
                contadorYes += 1
            else:
                contadorNo += 1
    try:
        prSI = (contadorYes / contador) * 100
    except:
        pass
    try:
     prNO = (contadorNo / contador) * 100
    except:
        pass
    for i in vector:
        #Excelente, Muy bueno, Bueno, Regular, Malo, Muy malo
        if nombreDeProfesor == i.get_nombre():
            if i.get_Respuesta2() == 'Excelente':
                varExcelente +=1
            elif i.get_Respuesta2() == 'Muy bueno':
                varMuyBueno +=1
            elif i.get_Respuesta2() == 'Bueno':
                varBueno +=1
            elif i.get_Respuesta2() == 'Regular':
                varRegular +=1
            elif i.get_Respuesta2() == 'Malo':
                varMalo +=1
            else:
                varMuyMalo +=1
    try:
        prExcelente = (varExcelente / contador) * 100
    except:
        pass
    try:
        prMuyBueno = (varMuyBueno / contador) * 100
    except:
        pass
    try:
        prBueno = (varBueno / contador) * 100
    except:
        pass
    try:
        prRegular = (varRegular / contador) * 100
    except:
        pass
    try:
        prMalo = (varMalo / contador) * 100
    except:
        pass
    try:
        prMuyMalo = (varMuyMalo / contador) * 100
    except:
        pass



    print("• El porcentaje de los que respondieron SI a \"¿Has asistido a todas las clases este semestre?\" \nfue de un ", prSI,"% de los estudiantes")
    print("• El porcentaje de los que respondieron NO a \"¿Has asistido a todas las clases este semestre?\" \nfue de un ", prNO,"% de los estudiantes")
    print("• Los votos en total sobre \"¿Como califica ústed al profesor en la siguiente escala?\" \n ► Excelente: ", prExcelente, "\n ► Muy bueno: ", prMuyBueno, "\n ► Bueno: ", prBueno, "\n ► Regular: ", prRegular, "\n ► Malo: ", prMalo, "\n ► Muy malo: ", prMuyMalo)

 
def aplicacionForm():
    global vector
    nombre = input("Inserte el nombre del profesor: ")
    carrera = input("Inserte la carrera que pertenece: ")
    periodoLectivo = input("Inserte el periodo lectivo actual: ")
    Respuesta1 = input("¿Has asistido a todas las clases este semestre? SI o NO: ")
    Respuesta2 = input("¿Como califica ústed al profesor en la siguiente escala?\nExcelente, Muy bueno, Bueno, Regular, Malo, Muy malo: ")
    dato1 = input("¿Cuál es tu opinión sobre la calidad de las explicaciones proporcionadas por tu profesor en las clases? Por favor, describe tus observaciones y experiencias en detalle: ")
    lista = [datosEstadisticos(nombre = nombre, carrera = carrera, periodoLectivo = periodoLectivo, Respuesta1 = Respuesta1, Respuesta2 = Respuesta2, dato1 = dato1)]
    vector = np.append(vector, lista)
    #print(len(vector))

if __name__ == '__main__':
    while True:
        opcion = int(input("Eliga una de las opciones: 1. Realizar un formulario. \n1. Realizar un formulario\n2. Realizar un calculo estadistico\n3. Salir de la aplicación\n"))
        if opcion == 1:
            function()
        elif opcion ==2: 
            calculo()
        else:
            break