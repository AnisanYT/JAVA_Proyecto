class persona():
    def __init__(self, identificacion, nombre, apellido, telefono, email, vectorDientes):
        self._identificacion = identificacion
        self._nombre = nombre
        self._apellido =apellido
        self._telefono = telefono
        self._email = email
        self._vectorDientes = vectorDientes

    def get_identificacion(self):
        return self._identificacion
    def set_identificacion(self, id):
        self._identificacion = id

    def get_nombre(self):
        return self._nombre
    def set_nombre(self, name):
        self._nombre = name
        
    def get_apellido(self):
        return self._apellido
    def set_apellido(self, lastn):
        self._apellido = lastn
 
    def get_telefono(self):
        return self._telefono
    def set_telefono(self, te):
        self._telefono = te

    def get_email(self):
        return self._email
    def set_email(self, em):
        self._email = em

    def get_vectorDientes(self):
        return self._vectorDientes
    def set_vectorDientes(self, nuevo_vectorDientes):
        self._vectorDientes = nuevo_vectorDientes