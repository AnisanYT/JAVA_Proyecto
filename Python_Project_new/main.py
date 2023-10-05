import precesos
import time
import numpy as np
if __name__ == '__main__':
    password = "1234"
    instancia = precesos.procesos()
    print(" Bienvenido, aquí encontraras el mejor café de Costa Rica")
    print(" Tenemos estos cafè hasta el momento:")
    print("┌─────────────────────────────────────────────────────────────┐")
    instancia.impresionDeCafe()
    print("└─────────────────────────────────────────────────────────────┘")
    while True:
        print("¿Què deseas hacer?")#☕
        print("1. Ver màs informacion sobre los cafè")
        print("2. Añadir mas productos (Necesitas ser el dueño 🎶)")
        print("3. Borrar productos (Necestias ser el dueño 🎶)")
        print("4. Quiero salir")
        eleccion = int(input("Quiero la opciòn nùmero "))
        if eleccion == 1:
            print("┌─────────────────────────────────────────────────────────────┐")
            instancia.impresionDeCafe()
            cafe = int(input(" Ahora que haz visto el menù, dime, ¿Sobre cual cafè te interesa\n"
                  " saber màs? "))
            instancia.showDetails(cafe)
            print("└─────────────────────────────────────────────────────────────┘")
        elif eleccion == 2:
            instancia.addNewProduct()
        elif eleccion == 3:
            vectorDePosiciones = np.empty(0, dtype=int)
            print("┌─────────────────────────────────────────────────────────────┐")
            print(" Asi que quieres borrar un producto ❌")
            print(' Te muestro los productos disponibles para que tomes tu desiciòn')
            instancia.impresionDeCafe()
            cantidad = int(input("\n Dime, ¿Cuantos productos quieres borrar? \n"
                                 " Ingresa la cantidad de productos: "))
            for i in range(cantidad):
                posiciones = int(input(" Numero de producto: "))
                vectorDePosiciones = np.append(vectorDePosiciones, posiciones)
            instancia.deleteProduct(vectorDePosiciones)
            print("└─────────────────────────────────────────────────────────────┘")
        else:
            print("\rSaliendo.", end='', flush=True)
            time.sleep(0.5)
            print("\rSaliendo..", end='', flush=True)
            time.sleep(0.5)
            print("\rSaliendo...", end='', flush=True)
            time.sleep(0.5)
            print("\rSaliendo.", end='', flush=True)
            time.sleep(0.5)
            print("\rSaliendo..", end='', flush=True)
            time.sleep(0.5)
            print("\rSaliendo...", end='', flush=True)
            time.sleep(0.5)
            print("¡Saliò del prgrama exitosamente, vuelva pronto!")
            break
        #eleccion = int(input("Selecciona una de las opciones para mostrarte mas detalles:"))
        #instancia.showDetails(eleccion)
