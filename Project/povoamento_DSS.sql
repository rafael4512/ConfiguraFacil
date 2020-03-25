USE `ConfiguraFacil`;
-- Povoamento da tabela "Empregado"

INSERT INTO Empregado
	(UserName, Password)
	VALUES 
		('ajaimeLeite','jleite'),
        ('ajoaoMarques','marquinhos'),
        ('mnunoRei','king'),
		('mrafaelLourenço','rafa');

INSERT INTO Componente
	(ID,Tipo,Nome,Descricao,Preco,Quantidade)
	VALUES 
		('e01','motor','MotorV_1.0','Motor 1000 de cilindrada com os cilindros dispostos em forma de V',600.0,10),
		('e02','motor','MotorV_1.4','Motor 1400 de cilindrada com os cilindros dispostos em forma de V',620.0,10),
		('e03','motor','MotorV_1.6','Motor 1600 de cilindrada com os cilindros dispostos em forma de V',640.0,10),
		('e04','motor','MotorV_1.8','Motor 1800 de cilindrada com os cilindros dispostos em forma de V',660.0,0),
		('e05','motor','MotorV_2.0','Motor 2000 de cilindrada com os cilindros dispostos em forma de V',680.0,10),
		('e06','motor','MotorW_1.0','Motor 1000 de cilindrada com cilindros dispostos em forma de W',700.0,10),
		('e07','motor','MotorW_1.4','Motor 1400 de cilindrada com cilindros dispostos em forma de W',720.0,10),
		('e08','motor','MotorW_1.6','Motor 1600 de cilindrada com cilindros dispostos em forma de W',740.0,10),
		('e09','motor','MotorW_1.8','Motor 1800 de cilindrada com cilindros dispostos em forma de W',760.0,10),
		('e10','motor','MotorW_2.0','Motor 2000 de cilindrada com cilindros dispostos em forma de W',780.0,10),
		('e11','motor','MotorVertical_1.0','Motor 1000 de cilindrada com cilindros alinhados longitudinalmente e com pistões posicionados em pé',800.0,10),
		('e12','motor','MotorVercial_1.4','Motor 1400 de cilindrada com cilindros alinhados longitudinalmente e com pistões posicionados em pé',820.0,10),
		('e13','motor','MotorVertical_1.6','Motor 1600 de cilindrada com cilindros alinhados longitudinalmente e com pistões posicionados em pé',840.0,10),
		('e14','motor','MotorVertical_1.8','Motor 1800 de cilindrada com cilindros alinhados longitudinalmente e com pistões posicionados em pé',860.0,10),
		('e15','motor','MotorVertical_2.0','Motor 2000 de cilindrada com cilindros alinhados longitudinalmente e com pistões posicionados em pé',880.0,10),
		('e16','motor','MotorBoxer_1.0','Motor de cilindrada 1000 cujos pistões são contrapostos e trabalham paralelamente ao solo',900.0,10),
		('e17','motor','MotorBoxer_1.4','Motor de cilindrada 1400 cujos pistões são contrapostos e trabalham paralelamente ao solo',920.0,10),
		('e18','motor','MotorBoxer_1.6','Motor de cilindrada 1600 cujos pistões são contrapostos e trabalham paralelamente ao solo',940.0,10),
		('e19','motor','MotorBoxer_1.8','Motor de cilindrada 1800 cujos pistões são contrapostos e trabalham paralelamente ao solo',960.0,10),
		('e20','motor','MotorBoxer_2.0','Motor de cilindrada 2000 cujos pistões são contrapostos e trabalham paralelamente ao solo',980.0,10),
		('e21','pintura','PinturaSolidaVermelha','Pintura simples, de cor vermelha, que contêm poliéster/poliuretano na sua composicao',500.0,15),
		('e22','pintura','PinturaSolidaAzul','Pintura simples, de cor azul, que contêm poliéster/poliuretano na sua composicao',500.0,15),
		('e23','pintura','PinturaSolidaBranca','Pintura simples, de cor branca, que contêm poliéster/poliuretano na sua composicao',500.0,15),
		('e24','pintura','PinturaSolidaPreta','Pintura simples, de cor preta, que contêm poliéster/poliuretano na sua composicao',500.0,15),
		('e25','pintura','PinturaMetalicaCinzenta','Pintura de cor cinzenta que reflete com mais precisão e qualidade a luz sobre o veículo',600.0,15),
		('e26','pintura','PinturaMetalicaPreta','Pintura de cor preta que reflete com mais precisão e qualidade a luz sobre o veículo',600.0,15),
		('e27','pintura','PinturaPerolizadaBranca','Pintura de cor branca que pode variar com o tipo de exposição à luz',700.0,15),
		('e28','pintura','PinturaPerolizadaPreta','Pintura de cor preta que pode variar com o tipo de exposição à luz',700.0,15),
		('e29','jante','JanteLL17','Jantes de liga leve de 17 polegadas que são mais leves, o que permite diminuir o peso das massas não suspensas e baixar o centro de gravidade do veículo',65.0,50),
		('e30','jante','JanteLL18','Jantes de liga leve de 18 polegadas que são mais leves, o que permite diminuir o peso das massas não suspensas e baixar o centro de gravidade do veículo',65.0,50),
		('e31','jante','JanteLL19','Jantes de liga leve de 19 polegadas que são mais leves, o que permite diminuir o peso das massas não suspensas e baixar o centro de gravidade do veículo',65.0,50),
		('e32','jante','JanteLL20','Jantes de liga leve de 20 polegadas que são mais leves, o que permite diminuir o peso das massas não suspensas e baixar o centro de gravidade do veículo',65.0,50),
		('e33','jante','JanteFundida17','Jante fundida de 17 polegadas que é construída através da coloccação a liga metálica a alta temperatura num molde especialmente estudado e com o formato da jante',70.0,50),
		('e34','jante','JanteFundida18','Jante fundida de 18 polegadas que é construída através da coloccação a liga metálica a alta temperatura num molde especialmente estudado e com o formato da jante',70.0,50),
		('e35','jante','JanteFundida19','Jante fundida de 19 polegadas que é construída através da coloccação a liga metálica a alta temperatura num molde especialmente estudado e com o formato da jante',70.0,50),
		('e36','jante','JanteFundida20','Jante fundida de 20 polegadas que é construída através da coloccação a liga metálica a alta temperatura num molde especialmente estudado e com o formato da jante',70.0,50),
		('e37','jante','JanteForjada17','Jante de 17 polegadas construída a partir de blocos de alumínio prensados com cargas acima das dezenas de tonelada',75.0,50),
		('e38','jante','JanteForjada18','Jante de 18 polegadas construída a partir de blocos de alumínio prensados com cargas acima das dezenas de tonelada',75.0,50),
		('e39','jante','JanteForjada19','Jante de 19 polegadas construída a partir de blocos de alumínio prensados com cargas acima das dezenas de tonelada',75.0,50),
		('e40','jante','JanteForjada20','Jante de 20 polegadas construída a partir de blocos de alumínio prensados com cargas acima das dezenas de tonelada',75.0,50),
		('e41','jante','JanteModular17','Jante de 17 polegadas que é composta por dois ou três componentes diferentes para formar a jante, chamando-se frequentemente bipartidas ou tripartidas',80.0,50),
		('e42','jante','JanteForjada18','Jante de 18 polegadas que é composta por dois ou três componentes diferentes para formar a jante, chamando-se frequentemente bipartidas ou tripartidas',80.0,50),
		('e43','jante','JanteModular19','Jante de 19 polegadas que é composta por dois ou três componentes diferentes para formar a jante, chamando-se frequentemente bipartidas ou tripartidas',80.0,50),
		('e44','jante','JanteModular20','Jante de 20 polegadas que é composta por dois ou três componentes diferentes para formar a jante, chamando-se frequentemente bipartidas ou tripartidas',80.0,50),
		('e45','estofos','EstofosPeleCastanho','Estofos em pele(maior comodidade) de cor castanha',60.0,50),
		('e46','estofos','EstofosPelePreto','Estofos em pele(maior comodidade) de cor preta',60.0,50),
		('e47','estofos','EstofosTecidoCastanho','Estofos em tecido de cor preta',50.0,50),
		('e48','estofos','EstofosTecidoPreto','Estofos em tecido de cor preta',50.0,50),
		('e49','pneus','Continental175','Pneu da marca Continental de 175 milimetros',75.0,200),
		('e50','pneus','Michelin175','Pneu da marca Michelin de 175 milimetros',80.0,200),
		('e51','pneus','Pirelli175','Pneu da marca Pirelli de 175 milimetros',90.0,200),
		('e52','pneus','Yokohama175','Pneu da marca Yokohama de 175 milietros',95.0,200),
		('e53','pneus','Continental180','Pneu da marca Continental de 180 milimetros',85.0,200),
		('e54','pneus','Michelin180','Pneu da marca Michelin de 180 milimetros',90.0,200),
		('e55','pneus','Pirelli180','Pneu da marca Pirelli de 180 milimetros',100.0,200),
		('e56','pneus','Yokohama180','Pneu da marca Yokohama de 180 milietros',105.0,200),
		('e57','pneus','Continental190','Pneu da marca Continental de 190 milimetros',95.0,200),
		('e58','pneus','Michelin190','Pneu da marca Michelin de 190 milimetros',100.0,200),
		('e59','pneus','Pirelli190','Pneu da marca Pirelli de 190 milimetros',110.0,200),
		('e60','pneus','Yokohama190','Pneu da marca Yokohama de 190 milietros',115.0,200),
        ('o61','farois','Faróis Xénon','Pouco consumo de energia e maior durabilidade',450.0,20),
		('o62','estacionamento','Sensores de estacionamento','Melhoram a segurança na condução, permitindo detetar veículos ou outros obstáculos',200.0, 10),
		('o63','gps','Sistema de navegação','GPS incluído para que seja facilitada a deslocação entre localidades',300.0, 10),
		('o64','mudancas','Caixa de velocidades automatica6V','Maior facilidade na condução com 6 mudanças de velocidade',400.0, 30),
		('o65','mudancas','Caixa de velocidades automatica7V','Maior facilidade na condução com 7 mudanças de velocidade',500.0, 30),
		('o66','arcondicionado','Ar condicionado bi-lateral', 'Ar condicionado igualmente distribuído pelos dois lados do automóvel',800.0, 10),
		('o67','sbiciclete','Suporte para bicicleta','Suporte para colocar até 2 bicicletas',100.0,15),
		('o68','spoiler','Spoiler100', 'Spoiler de tamanho 100 cm ',80.0,10),
		('o69','spoiler','Spoiler150','Spoiler de tamnaho 150 cm',90.0,10),
		('o70','bancos','Bancos aquecidos', 'Proporcionam maior conforto e relaxamento durante a viagem no automóvel',500.0, 10);
       
INSERT INTO Pacote
	(Id,preco)
	VALUES 
		('Pacote Sport',927.0),
		('Pacote Business',540.0),
		('Pacote Confort',1170.0),
        ('Pacote Viagem',540.0);

INSERT INTO ComponentePacote
	(IdComponente,IdPacote)
	VALUES 
		('o61','Pacote Sport'),
        ('o65','Pacote Sport'),
        ('o68','Pacote Sport'),
        ('o62','Pacote Business'),
        ('o64','Pacote Business'),
        ('o66','Pacote Confort'),        
        ('o70','Pacote Confort'),
        ('o62','Pacote Viagem'),
		('o63','Pacote Viagem'),
		('o67','Pacote Viagem');
        
INSERT INTO ComponenteNecessidade
	(IdComponente,IdNecessidade)
	VALUES 
		('o61','o65'),
        ('o63','o62'),
        ('o64','o62'),
        ('o70','o66');

INSERT INTO ComponenteIncompatibilidade
	(IdComponente,IdIncompatibilidade)
	VALUES 
		('o61','o62'),
        ('o62','o61'),
        ('o64','o65'),
        ('o65','o64'),
        ('o62','o70'),
        ('o70','o62'),
        ('o69','o68'),
        ('o68','o69');

-- configuracao 2 tem um pacote
INSERT INTO Configuracao
	(Id, Preco)
    VALUES
		('1',1885.0),
        ('2',2750.0);        

INSERT INTO ComponenteConfiguracao
	(IdComponente, IdConfiguracao)
    VALUES
		('e04','1'),
        ('e23','1'),
        ('e31','1'),
        ('e48','1'),
        ('e50','1'),
        ('o61','1'),
        ('o68','1'),
        ('e15','2'),
        ('e22','2'),
        ('e29','2'),
        ('e45','2'),
        ('e49','2'),
        ('o66','2'),
        ('o70','2');