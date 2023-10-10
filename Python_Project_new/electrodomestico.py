class productos(): 
    def __init__(self, marca, modelo, precio, base, color, consumoEnergetico, peso):
        self._marca = marca
        self._modelo = modelo
        self._precio = precio
        self._base = base
        self._color = color
        self._consumoEnergetico = consumoEnergetico
        self._peso = peso


    def get_marca(self):
        return self._marca

    def get_modelo(self):
        return self._modelo

    def get_precio(self):
        return self._precio

    def get_base(self):
        return self._base

    def get_color(self):
        return self._color

    def get_consumoEnergetico(self):
        return self._consumoEnergetico

    def get_peso(self):
        return self._peso


    def set_marca(self, nueva_marca):
        self._marca = nueva_marca

    def set_modelo(self, nuevo_modelo):
        self._modelo = nuevo_modelo

    def set_precio(self, nuevo_precio):
        self._precio = nuevo_precio

    def set_base(self, nueva_base):
        self._base = nueva_base

    def set_color(self, nuevo_color):
        self._color = nuevo_color

    def set_consumoEnergetico(self, nuevo_consumoEnergetico):
        self._consumoEnergetico = nuevo_consumoEnergetico

    def set_peso(self, nuevo_peso):
        self._peso = nuevo_peso