from persona import persona
from dientes import dientes
import numpy as np
#inicializar el vector de todos los dientes.
listaDeDientesNamesSuperior = ['Incisivo Central', 'Canino', 'Segundo pré molar', 'Segundo molar', 'Terceiro molar', 'primeiro molar', 'primero pré molar', 'incisivo lateral']
listaDeDientesNamesInferior = ['Segundo molar', 'Segundo pré molar', 'canino', 'incisivo central', 'incisivo lateral', 'primeiro pré molar', 'terceiro molar']


def initCompleteList():
        listaCompleta = []
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
        return listaCompleta
                        
#for i in listaCompleta:
#     print(i.get_nombreDiente(), i.get_posicionEnArco()) 
listaDientes = [dientes(nombreDiente="canino", posicionEnArco="arco superior", tratamiento="Sin tratamiento por el momento", operaciones="Sin operaciones por el momento", extraciones="Sin extracion", limpieza="Sin limpieza")]
lista = [persona(nombre= "Mateo", apellido="Mendez", identificacion="0123456", telefono="22920921", email="mendez21@gmail.com", vectorDientes= initCompleteList())]

cliente = np.array(lista)

#listaAuxiliar[0].set_tratamiento("Tratamiento de bueno ")

def function():
        #print(cliente[0])
        id = input("Por favor, inserte el número de identificación del pasciente: ")
        encontrado = False
        for i in cliente:
              if i.get_identificacion() == id:
                    encontrado = True
                    listasDientesw = i.get_vectorDientes()
                    print("Lista de dientes de ", i.get_nombre(), "\nIdentificación: ", i.get_identificacion())
                    contador = 0
                    for o in listasDientesw:
                          print(contador, o.get_nombreDiente())
                          contador += 1
                    opcionDienteShow = int(input("¿Cual desea ver?: "))
                    print("Esta es la informacion sobre: ", listasDientesw[opcionDienteShow].get_nombreDiente())
                    print("Posicion del diente: ", listasDientesw[opcionDienteShow].get_posicionEnArco())
                    print("Tratamiento: ", listasDientesw[opcionDienteShow].get_tratamiento())
                    print("Operaciones: ", listasDientesw[opcionDienteShow].get_operaciones())
                    print("Extraciones: ", listasDientesw[opcionDienteShow].get_extracciones())
                    print("Limpieza: ", listasDientesw[opcionDienteShow].get_limpieza())
     
                    
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
                    opcionDeleteCompleteOrNot = int(input("¿Desea borrar todo el registro hasta el momento o añadir?\n1. Añadir\n2. Borrar")) 
                    opcionChange = int(input("¿Qué aspecto desea editar?: \n1. Tratamiento\n2. Operaciones\n3. Extraciones\n4. Limpieza"))
                    if opcionChange == 1:
                          if opcionDeleteCompleteOrNot == 1:
                                aux = listas[opcionDienteEdit].get_tratamiento()
                                newEdi = input("Escriba las nuevas notas al tratamiento: \n- ")
                                newEditForUpdate = aux +"\n"+ newEdi
                                listas[opcionDienteEdit].set_tratamiento(newEditForUpdate)
                                print(listas[opcionDienteEdit].get_tratamiento())
                          else:     
                                newEdi = input("Escriba las nuevas notas al tratamiento: \n- ")
                                listas[opcionDienteEdit].set_tratamiento(newEdi)
                                print(listas[opcionDienteEdit].get_tratamiento())
                    elif opcionChange == 2:
                          if opcionDeleteCompleteOrNot == 1:
                                aux = listas[opcionDienteEdit].get_operaciones()
                                newEdi = input("Escriba las nuevas notas a las operaciones: \n- ")
                                newEditForUpdate = aux +"\n"+ newEdi
                                listas[opcionDienteEdit].set_tratamiento(newEditForUpdate)
                                print(listas[opcionDienteEdit].get_operaciones())
                          else:     
                                newEdi = input("Escriba las nuevas notas a las operaciones: \n- ")
                                listas[opcionDienteEdit].set_operaciones(newEdi)
                                print(listas[opcionDienteEdit].get_operaciones())
                    elif opcionChange == 3:
                          if opcionDeleteCompleteOrNot == 1:
                                aux = listas[opcionDienteEdit].get_extracciones()
                                newEdi = input("Escriba las nuevas notas a las extracciones: \n- ")
                                newEditForUpdate = aux +"\n"+ newEdi
                                listas[opcionDienteEdit].set_extracciones(newEditForUpdate)
                                print(listas[opcionDienteEdit].get_extracciones())
                          else:     
                                newEdi = input("Escriba las nuevas notas a las extracciones: \n- ")
                                listas[opcionDienteEdit].set_extracciones(newEdi)
                                print(listas[opcionDienteEdit].get_extracciones())
                    else:
                          if opcionDeleteCompleteOrNot == 1:
                                aux = listas[opcionDienteEdit].get_limpieza()
                                newEdi = input("Escriba las nuevas notas de limpieza: \n- ")
                                newEditForUpdate = aux +"\n"+ newEdi
                                listas[opcionDienteEdit].set_limpieza(newEditForUpdate)
                                print(listas[opcionDienteEdit].get_limpieza())
                          else:     
                                newEdi = input("Escriba las nuevas notas a las extracciones: \n- ")
                                listas[opcionDienteEdit].set_limpieza(newEdi)
                                print(listas[opcionDienteEdit].get_limpieza())
                     
                          


        

        
if __name__ == '__main__':
    
    #listaAuxiliar = cliente[0].get_vectorDientes()
    #listaAuxiliar[0].set_tratamiento("Tratamiento ss")
    while True:
          opcion = int(input("Bienvenido.\n¿Qué desea hacer?\n1. Añadir un nuevo pasciente. \n2. Ver informacion de pasciente. \n3. Editar \n4. Salir. \n - "))
          if opcion == 1:
                nombre = input("Inserte el nombre: ")
                apellido = input("Apellido: ")
                ids = input("Identificación: ")
                telefono = input("Telefono: ")
                email = input("Correo Electronico: ")
                listaCliente = [persona(nombre= nombre, apellido=apellido, identificacion=ids, telefono=telefono, email=email, vectorDientes= initCompleteList())]
                cliente = np.append(cliente, listaCliente)
                iFChange = int(input("¿Quieres cambiar algo?: \n1. Si \n2. No"))
                if iFChange == 1:
                      editar()
          elif opcion == 2:
                function()
          elif opcion == 3: 
                editar()
          else:
                break

    #for i in listaCompleta:
    #      print(i.get_nombreDiente(), i.get_posicionEnArco()) 