import precesos
if __name__ == '__main__':
    instancia = precesos.procesos()
    print(" Bienvenido, aquí encontraras el mejor café de Costa Rica")
    print(" Tenemos estos cafè hasta el momento:")
    print("┌─────────────────────────────────────────────────────────────┐")
    instancia.impresionDeCafe()
    print("└─────────────────────────────────────────────────────────────┘")
    eleccion = int(input("Selecciona una de las opciones para mostrarte mas detalles:"))
    instancia.showDetails(eleccion)
