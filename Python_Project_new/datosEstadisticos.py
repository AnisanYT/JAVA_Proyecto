class datosEstadisticos():
    def __init__(self, nombre = "", carrera = "", periodoLectivo = "", Respuesta1 = "", Respuesta2 = "", dato1 = ""):
        self._nombre  = nombre
        self._carrera = carrera
        self._periodoLectivo = periodoLectivo
        self._Respuesta1 = Respuesta1
        self._Respuesta2 = Respuesta2
        self._dato1 = dato1
    
    def get_nombre(self):
        return self._nombre
    def set_nombre(self, nm):
        self._nombre = nm

    def get_carrera(self):
        return self._carrera
    def set_carrera(self, crr):
        self._carrera = crr

    def get_periodoLectivo(self):
        return self._periodoLectivo
    def set_periodoLectivo(self, pl):
        self._periodoLectivo = pl
    
    def get_Respuesta1(self):
        return self._Respuesta1
    def set_Respuesta1(self, runo):
        self._Respuesta1 = runo

    def get_Respuesta2(self):
        return self._Respuesta2
    def set_Respuesta2(self, rdos):
        self._Respuesta2 = rdos

    def get_dato1(self):
        return self._dato1
    def set_dato1(self, duno):
        self._dato1 = duno
    

    