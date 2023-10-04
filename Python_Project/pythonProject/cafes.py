from atributosCoffe import fathAttributes
class coffeDetails(fathAttributes):
    def __init__(self,  coffeName = "", receta = "", precio = "", textura = "", aroma = "", sabor = ""):
        super().__init__(textura, aroma, sabor)
        self._coffeName = coffeName
        self._receta = receta
        self._precio = precio

    def get_coffeName(self):
        return self._coffeName
    def set_coffeName(self, cn):
        self._coffeName = cn

    def get_receta(self):
        return self._receta
    def set_receta(self, rt):
        self._receta = rt

    def get_precio(self):
        return self._precio
    def set_precio(self, pr):
        self._precio = pr

