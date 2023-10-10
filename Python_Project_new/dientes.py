class dientes():
    def __init__(self, nombreDiente, posicionEnArco, tratamiento, operaciones, extraciones, limpieza):
        self._nombreDiente = nombreDiente
        self._posicionEnArco = posicionEnArco
        self._tratamiento =tratamiento
        self._operaciones = operaciones
        self._extraciones = extraciones
        self._limpieza = limpieza

    def get_nombreDiente(self):
        return self._nombreDiente

    def get_posicionEnArco(self):
        return self._posicionEnArco

    def get_tratamiento(self):
        return self._tratamiento

    def get_operaciones(self):
        return self._operaciones

    def get_extracciones(self):
        return self._extraciones

    def get_limpieza(self):
        return self._limpieza
    



    def set_nombreDiente(self, nuevo_nombreDiente):
        self._nombreDiente = nuevo_nombreDiente

    def set_posicionEnArco(self, nueva_posicionEnArco):
        self._posicionEnArco = nueva_posicionEnArco

    def set_tratamiento(self, nuevo_tratamiento):
        self._tratamiento = nuevo_tratamiento

    def set_operaciones(self, nuevas_operaciones):
        self._operaciones = nuevas_operaciones

    def set_extracciones(self, nuevas_extracciones):
        self._extraciones = nuevas_extracciones

    def set_limpieza(self, nueva_limpieza):
        self._limpieza = nueva_limpieza

    def set_vectorDientes(self, nuevo_vectorDientes):
        self._vectorDientes = nuevo_vectorDientes
