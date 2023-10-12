from televisores import tv 
from refrigeradora import refri
import numpy as np
lita = [tv(marca="LG", modelo="HG120", precio=45000, base="estandar", color="negro", consumoEnergetico="C", peso=14.6, resolucion="1280px720p", aspecto="16:9", screenSize="28 pulgadas")]
televisores = np.array(lita)
litilla = [refri("LG", modelo="RF001G", precio=63000, base="Original OEM", color="Gris", consumoEnergetico="A", peso=80.21, puertas="1", pulgadas="11", piesCub="27", freezer="Arriba")]
refrigeradoras = np.array(litilla)
def saveTV():
    global televisores
    marca = input("marca: ")
    modelo = input("modelo: ")
    precio = int(input("precio: "))
    base = input("base: ")
    color = input("color: ")
    consumo = input("Consumo energetico(A - F): ")
    peso = float(input("peso(kg): "))
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
    elif peso > 20 and peso < 49:
        precio += 30750
    elif peso > 50 and peso < 79:
        precio += 49200
    elif peso > 80:
        precio += 61500
    #print("Al final el precio es de: ", precio)
    lita = [tv(marca=marca, modelo=modelo, precio=precio, base=base, color=color, consumoEnergetico=consumo, peso=peso, resolucion=resolucion, aspecto=aspecto, screenSize= screenSize)]
    televisores = np.append(televisores, lita)
    print("¡Producto registrado!")
    print(televisores)
def saveFreeze():
    global refrigeradoras
    marca = input("marca: ")
    modelo = input("modelo: ")
    precio = int(input("precio: "))
    base = input("base: ")
    color = input("color: ")
    consumo = input("Consumo energetico(A - F): ")
    peso = float(input("peso(kg): "))
    puertas = input("Numero de puertas: ")
    pulgadas = input("Pulgadas: ")
    piesCub = input("Pies cubicos: ")
    freezer = input("Posicion del Freezer: ")
    listita = [refri(marca=marca, modelo=modelo, precio=precio, base=base, color=color, consumoEnergetico=consumo, peso=peso, puertas=puertas,pulgadas=pulgadas, piesCub=piesCub, freezer=freezer)]
    refrigeradoras = np.append(refrigeradoras, listita)
def showTV():
    contador = 0
    global televisores
    for i in televisores:
        print(contador,". " ,"Marca: ",i.get_marca(),"  Modelo: ", i.get_modelo())
        contador += 1
    moreDetail = int(input("Quieres saber más sobre... (Número): "))
    o = televisores[moreDetail]
    print(f'Información sobre {o.get_marca()} modelo {o.get_modelo()}\nPrecio: {o.get_precio()}\nBase: {o.get_base()}\nColor: {o.get_color()}\nConsumo energetico: {o.get_consumoEnergetico()}\nPeso: {o.get_peso()}kg\nResolución: {o.get_resolucion()}\nAspecto: {o.get_aspecto()}\nTamaño de pantalla: {o.get_screenSize()}')
def showFreeze():
    contador = 0
    global refrigeradoras
    for i in refrigeradoras:
        print(contador,". " ,"Marca: ",i.get_marca(),"  Modelo: ", i.get_modelo())
        contador += 1
    moreDetail = int(input("Quieres saber más sobre... (Número): "))
    o = refrigeradoras[moreDetail]
    print(f'Información sobre {o.get_marca()} modelo {o.get_modelo()}\nPrecio: {o.get_precio()}\nBase: {o.get_base()}\nColor: {o.get_color()}\nConsumo energetico: {o.get_consumoEnergetico()}\nPeso: {o.get_peso()}kg\nPuertas: {o.get_puertas()}\nPulgadas: {o.get_pulgadas()}\nPies cubicos: {o.get_piesCub()}\nPosición del freezer: {o.get_freezer()}')
if __name__ == '__main__':
    while True:
        print("¿Que deseas hacer?")
        opcion = int(input("1. Añadir un producto\n2. Ver productos\n3. Salir\n -"))
        if opcion == 1:
            print("Por el momento, solo puedes registrar \n1. Televisores\n2. Refrigeradoras\n")
            opcionValue = int(input("Eliga una opcion: "))
            if opcionValue == 1:
                saveTV()
            else:
                saveFreeze()
        elif opcion == 2:
            print("¿Qué deseas ver?\n1. Televisores\n2. Refrigeradoras")
            opcionEle = int(input("Inserte su opción: "))
            if opcionEle == 1:
                showTV()
            else: 
                showFreeze()
        else:
            break
