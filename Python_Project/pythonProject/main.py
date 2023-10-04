from cafes import coffeDetails
import numpy as np
def function(opc):
    print(f'Usted selecciono {opc}')
    lista1 = [coffeDetails(coffeName="Frape",receta="Café", precio=2000, textura="Riquisimo", aroma= "Vainilla", sabor= "Vainillita")]
    officialVector = np.array(lista1)
    print(officialVector[0].get_coffeName())
    lista1 = [coffeDetails(coffeName="Cappucino",receta="coffe with milk", precio=750, textura="Super riquisimo", aroma= "Chocolate", sabor= "Chocolatito")]
    officialVector = np.append(officialVector, lista1) #se le tiene que dar el mismo vecto en principio como argumento
    print(officialVector[1].get_aroma())
if __name__ == '__main__':
    print("Bienvenido, aquí encontraras el mejor café de Costa Rica")
    print("Tenemos variedades de cafés y servicios como: ")
    print("1. Frios         | 2. Calientes  \n"
          "3. Bebida        | 4. Postres    \n"
          "5. Simples       | 6. Compuestos \n"
          "6. Con alcohol   | 7. Sin alcohol")

    eleccion = input("Selecciona una de las opciones para mostrarte mas detalles:")
    function(eleccion)