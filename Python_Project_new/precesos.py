from cafes import coffeDetails
import time as t
import random as rd
#Aqui tendre un vector con los distintos cafè que hay en el negocio
import numpy as np

lista1 = [coffeDetails(coffeName="Frape",receta="Café", precio=2000, aroma="Vainillita", sabor= "Vainilla", textura= "rico")]
officialVector = np.array(lista1) #Esta es el vector donde guardare todos los datos
lista1 = [coffeDetails(coffeName="Latte",receta="agua, espresso, azúcar, leche y hielo", precio=1500, aroma="chocolatito", sabor= "chocolate", textura= "Super rico")]
#Con esto podemos actualizar el vector usando un metodo de numpy
officialVector = np.append(officialVector, lista1)
#se le tiene que dar el mismo vecto en principio como argumento
#Asi es como podemos imprimir uno de los datos
#print(officialVector[1].get_aroma())

class procesos():
    def impresionDeCafe(self):
        aux = 0
        print(" Hola, es un placer atenderte, aqui te muestro \n"
              " todos los cafè que tenemos disponibles: ")
        for i in officialVector:
            print(f"    {aux} . {i.get_coffeName()}") #No es necesario darle la posicion pues "i" recoge los datos
            aux += 1
    def showDetails(self, aux):
        tamano = len(officialVector)
        #Recordar, el tamaño que me da es desde 1 hacia arriba, por lo que si queremos
        #usar este tamño siempre debemos restar uno.
        if aux <= tamano-1: #<- tal como sucede aquì.
            nombre = officialVector[aux].get_coffeName()
            print("┌─────────────────────────────────────────────────────────────┐")
            print(f'    Has decidido ver màs sobre ♥{nombre}♥')
            print(f'    ● Su precio es: {officialVector[aux].get_precio()} colones')
            print(f'    ● Receta de {nombre}:')
            print(f'        {officialVector[aux].get_receta()}')
            print(f'    ● Textura: {officialVector[aux].get_textura()}')
            print(f'    ● Su aroma es de: {officialVector[aux].get_aroma()}')
            print(f'    ● Sabor a: {officialVector[aux].get_sabor()}')
            print("└─────────────────────────────────────────────────────────────┘")
        else:
            print("┌─────────────────────────────────────────────────────────────┐")
            print("     Oh, parece que haz seleccionado algo que no existe. \n"
                  "     Tranqui, todos cometemos errores, intenta nuevamente :D")
            print("└─────────────────────────────────────────────────────────────┘")
    def addNewProduct(self):
        global officialVector #Indica que usaremos el vector preestablecido
        #Esto nos permite establecer cambios
        print("┌─────────────────────────────────────────────────────────────┐")
        print(" Hola, asi que quieres añadir un nuevo producto, empecemos \n"
              " por darle un nombre.")
        nombre = input(" ► ¿Cual serà el nombre? ")
        receta = input(" ► Importante, la receta: ")
        aroma = input(" ► Me gustarìa saber a que huele: ")
        sabor = input(" ► ¿Y a que sabe? ")
        textura = input(" ► ¿Cual es su textura? ")
        precio = int(input("    ►¿Cual serà el precio? "))
        time_wait = rd.randrange(3, 6) #De 3 a 5
        for i in range(time_wait):
            if  i % 2 == 0:
                print(" \r♫Estoy registrando tu nuevo producto", end='', flush=True)
                #end es para que siga en la misma linea
                #flush es para que borre lo que hay en esa linea cuando imprima otra
                #\r es para imprimir desde el principio
                t.sleep(1)
            else:
                print(" \rEstoy registrando tu nuevo producto♫", end='', flush=True)
                t.sleep(1)
        lista = [coffeDetails(coffeName= nombre,receta=receta, precio=precio, aroma=aroma, sabor= sabor, textura= textura)]
        officialVector = np.append(officialVector ,lista)
        print("\r¡Listo! Ya esta registrado. ☺")
        print("└─────────────────────────────────────────────────────────────┘")




