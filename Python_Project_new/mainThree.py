from persona import persona
from dientes import dientes
import numpy as np
#inicializar el vector de todos los dientes.
listaDeDientesNamesSuperior = ['Incisivo Central', 'Canino', 'Segundo pré molar', 'Segundo molar', 'Terceiro molar', 'primeiro molar', 'primero pré molar', 'incisivo lateral']
listaDeDientesNamesInferior = ['Segundo molar', 'Segundo pré molar', 'canino', 'incisivo central', 'incisivo lateral', 'primeiro pré molar', 'terceiro molar']

listaCompleta = []
def initCompleteList():
        for i in listaDeDientesNamesSuperior:
              nombreDiente = i
              posicionEnArco = "arco superior"
              tratamiento = "Sin tratamiento"
              operaciones = "Sin operacion"
              extraciones = "Sin extracion"
              limpieza = "Sin limpieza"
              listaCompleta.append(dientes(nombreDiente=nombreDiente, posicionEnArco=posicionEnArco, tratamiento=tratamiento, operaciones=operaciones, extraciones=extraciones, limpieza=limpieza))
        for i in  listaDeDientesNamesInferior:
              nombreDiente = i
              posicionEnArco = "arco inferior"
              tratamiento = "Sin tratamiento"
              operaciones = "Sin operacion"
              extraciones = "Sin extracion"
              limpieza = "Sin limpieza"
              listaCompleta.append(dientes(nombreDiente=nombreDiente, posicionEnArco=posicionEnArco, tratamiento=tratamiento, operaciones=operaciones, extraciones=extraciones, limpieza=limpieza))
                        
#for i in listaCompleta:
#     print(i.get_nombreDiente(), i.get_posicionEnArco()) 
listaDientes = [dientes(nombreDiente="canino", posicionEnArco="arco superior", tratamiento="Sin tratamiento por el momento", operaciones="Sin operaciones por el momento", extraciones="Sin extracion", limpieza="Sin limpieza")]
lista = [persona(nombre= "Mateo", apellido="Mendez", identificacion="0123456", telefono="22920921", email="mendez21@gmail.com", vectorDientes= listaCompleta)]

cliente = np.array(lista)

#listaAuxiliar[0].set_tratamiento("Tratamiento de los God papi")

def function():
        #print(cliente[0])
        id = input("Por favor, inserte el número de identificación del pasciente: ")
        encontrado = False
        for i in cliente:
              if i.get_identificacion() == id:
                    encontrado = True
                    listas = i.get_vectorDientes()
                    print("Lista de dientes de ", i.get_nombre(), "\nIdentificación: ", i.get_identificacion())
                    contador = 0
                    for o in listas:
                          print(contador, o.get_nombreDiente())
                          contador += 1
                    opcionDienteShow = int(input("¿Cual desea ver?: "))
                    print("Esta es la informacion sobre: ", listas[opcionDienteShow].get_nombreDiente())
                    print("Posicion del diente: ", listas[opcionDienteShow].get_posicionEnArco())
                    print("Tratamiento: ", listas[opcionDienteShow].get_tratamiento())
                    print("Operaciones: ", listas[opcionDienteShow].get_operaciones())
                    print("Extraciones: ", listas[opcionDienteShow].get_extracciones())
                    print("Limpieza: ", listas[opcionDienteShow].get_limpieza())
     
                    
        #listas = cliente[0].get_vectorDientes() #Primero, lo que tengo que hacer es guardar en una variable el vector dentro de del vector jaja
        #print(listas[0].get_nombreDiente()) #Luego, como tengo ya este vector en "litas" solamente lo trato como tal y acceso a su posicion.
        #print(listaDeDientesNamesSuperior[1])
def editar():
        id = input("Por favor, inserte el número de identificación del pasciente: ")
        encontrado = False
        for i in cliente:
              if i.get_identificacion() == id:
                    encontrado = True
                    listas = i.get_vectorDientes()
                    print("Lista de dientes de ", i.get_nombre(), "\nIdentificación: ", i.get_identificacion())
                    contador = 0
                    for o in listas:
                          print(contador, o.get_nombreDiente())
                          contador += 1
                    opcionDienteEdit = int(input("¿Cual desea editar?: ")) #Posicion de diente dentro del vector
                    opcionDeleteCompleteOrNot = int(input("¿Desea borrar todo el registro hasta el momento o añadir?")) 
                    opcionChange = int(input("¿Qué aspecto desea editar?: \n1. Tratamiento\n2. Operaciones\n3. Extraciones\n4. Limpieza"))
        

        
if __name__ == '__main__':
    initCompleteList()
    #listaAuxiliar = cliente[0].get_vectorDientes()
    #listaAuxiliar[0].set_tratamiento("Tratamiento ss")
    while True:
          opcion = int(input("Bienvenido.\n¿Qué desea hacer?\n1. Añadir un nuevo pasciente. \n2. Ver informacion de pasciente.\n3. Salir."))
          if opcion == 1:
                print("Aquí se podra añadir nuevos pascientes.")
          elif opcion == 2:
                function()
          else: 
                break
    #for i in listaCompleta:
    #      print(i.get_nombreDiente(), i.get_posicionEnArco()) 