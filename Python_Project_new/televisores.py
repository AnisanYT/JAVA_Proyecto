from electrodomestico import productos
class tv(productos):
    def __init__(self, marca, modelo, precio, base, color, consumoEnergetico, peso, resolucion, aspecto, screenSize):
        super().__init__(marca, modelo, precio, base, color, consumoEnergetico, peso)
        self._resolucion = resolucion
        self._aspecto = aspecto
        self._screenSize = screenSize
    def get_resolucion(self):
        return self._resolucion

    def get_aspecto(self):
        return self._aspecto

    def get_screenSize(self):
        return self._screenSize


    def set_resolucion(self, nueva_resolucion):
        self._resolucion = nueva_resolucion

    def set_aspecto(self, nuevo_aspecto):
        self._aspecto = nuevo_aspecto

    def set_screenSize(self, nuevo_screenSize):
        self._screenSize = nuevo_screenSize
        