from electrodomestico import productos
class refri(productos):
    def __init__(self, marca, modelo, precio, base, color, consumoEnergetico, peso, puertas, pulgadas, piesCub, freezer):
        super().__init__(marca, modelo, precio, base, color, consumoEnergetico, peso)
        self._puertas = puertas
        self._pulgadas = pulgadas
        self._puesCub = piesCub
        self._freezer = freezer
        
    def get_puertas(self):
        return self._puertas

    def get_pulgadas(self):
        return self._pulgadas

    def get_piesCub(self):
        return self._piesCub

    def get_freezer(self):
        return self._freezer


    def set_puertas(self, nuevas_puertas):
        self._puertas = nuevas_puertas

    def set_pulgadas(self, nuevas_pulgadas):
        self._pulgadas = nuevas_pulgadas

    def set_piesCub(self, nuevos_piesCub):
        self._piesCub = nuevos_piesCub

    def set_freezer(self, nuevo_freezer):
        self._freezer = nuevo_freezer