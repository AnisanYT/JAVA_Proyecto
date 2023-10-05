import precesos
if __name__ == '__main__':
    instancia = precesos.procesos()
    print(" Bienvenido, aquí encontraras el mejor café de Costa Rica")
    print(" Tenemos estos cafè hasta el momento:")
    print("┌─────────────────────────────────────────────────────────────┐")
    instancia.impresionDeCafe()
    print("└─────────────────────────────────────────────────────────────┘")
    print("¿Què deseas hacer?")#☕
    print("1. Ver màs informacion sobre los cafè")
    print("2. Añadir mas productos (Necesitas ser el dueño 🎶)")
    print("3. Borrar productos (Necestias ser el dueño 🎶)")
    eleccion = int(input("Quiero la opciòn nùmero "))
    if eleccion == 1:
        print("┌─────────────────────────────────────────────────────────────┐")
        instancia.impresionDeCafe()
        print("└─────────────────────────────────────────────────────────────┘")
    elif eleccion == 2:
        instancia.addNewProduct()
    else:
        print("Aquì se borran productos.")
    #eleccion = int(input("Selecciona una de las opciones para mostrarte mas detalles:"))
    #instancia.showDetails(eleccion)
