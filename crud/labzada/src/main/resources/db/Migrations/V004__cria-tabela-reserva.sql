CREATE TABLE reserva (
  codReserva INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  codTurma INT,
  codProfessor INT,
  codLaboratorio INT,
  dataReservada datetime,
  turno VARCHAR(255)
  );