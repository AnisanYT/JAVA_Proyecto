class fathAttributes():
    def __init__(self, aroma = "", sabor = "", textura = ""):
        self._aroma = aroma
        self._sabor = sabor
        self._textura = textura

    def get_aroma(self):
        return self._aroma
    def set_aroma(self, ar):
        self._aroma = ar

    def get_sabor(self):
        return self._sabor
    def set_sabor(self, sab):
        self._sabor = sab

    def get_textura(self):
        return self._textura
    def set_textura(self, tx):
        self._textura = tx