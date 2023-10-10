def function():
    print()

if __name__ == '__main__':
    print("¿Que deseas hacer?")
    opcion = int(input("1. Añadir un producto\n2. Ver productos\n3. Editar informacion de un producto\n -"))
    if opcion == 1:
        print("Por el momento, solo puedes registrar \n1. Televisores\n2. Refrigeradoras\n -")
        opcionValue = input("-")
        if opcionValue == 1:
            marca = input("marca: ")
            modelo = input("modelo: ")
            precio = input("precio: ")
            base = input("base: ")
            color = input("color: ")
            consumo = input("Consumo energetico(A - F): ")
            peso = input("peso(kg): ")
            resolucion = input("resolucion: ")
            aspecto = input("aspecto: ")
            screenSize = input("Tamaño de pantalla: ")
            if consumo == 'A' or consumo == 'a':
                precio += 61500
            elif consumo == 'B' or consumo == 'b':
                precio += 49200
            elif consumo == 'C' or consumo == 'c':
                precio += 36900
            elif consumo == 'D' or consumo == 'd':
                precio += 30750
            elif consumo == 'E' or consumo == 'e':
                precio += 18450
            else:
                precio += 6150
            
            if peso > 0 and peso < 19:
                precio += 6150
                

            

