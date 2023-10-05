from cafes import coffeDetails
#Aqui tendre un vector con los distintos cafè que hay en el negocio
import numpy as np
lista1 = [coffeDetails(coffeName="Frape",receta="Café", precio=2000, textura="Riquisimo", aroma= "Vainilla", sabor= "Vainillita")]
officialVector = np.array(lista1) #Esta es el vector donde guardare todos los datos
lista1 = [coffeDetails(coffeName="Latte",receta="Café y otras cosas", precio=1500, textura="Super rico", aroma= "chocolate", sabor= "chocolatito")]
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
        print(" Si quieres mas detalles de uno de ellos, solo indicame el numero y serà un placer \n"
              " mostrate mas detalles.")
    def showDetails(self, aux):
        tamano = len(officialVector)
        #Recordar, el tamaño que me da es desde 1 hacia arriba, por lo que si queremos
        #usar este tamño siempre debemos restar uno.
        if aux <= tamano-1: #<- Como sucede aquì.
            nombre = officialVector[aux].get_coffeName()
            print("┌─────────────────────────────────────────────────────────────┐")
            print(f'    Has decidido ver màs sobre {nombre}')
            print("└─────────────────────────────────────────────────────────────┘")
        else:
            print("┌─────────────────────────────────────────────────────────────┐")
            print("     Oh, parece que haz seleccionado algo que no existe. \n"
                  "     Tranqui, todos cometemos errores, intenta nuevamente :D")
            print("└─────────────────────────────────────────────────────────────┘")
