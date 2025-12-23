CREATE TABLE usuarios(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

INSERT INTO usuarios (nome, email, senha) VALUES
('Ana Silva', 'ana@mail.com', '$2a$12$chFukUR6JRSFYgPxIvTZKerX64gv0WFdAfr7OBrrvMnc7q8C4R3EC'),
('Paulo Sousa', 'ps@mail.com', '$2a$12$ZqaAQDHUXDaxDvCp9Xq72O6jhxRXsAacZc8ieIuU6QrXyrFG6j6qm');

CREATE TABLE produtos(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL,
    inserido_em TIMESTAMP NOT NULL,
    categoria ENUM('ELETRONICO', 'ROUPA', 'ESCRITORIO', 'MOVEIS') NOT NULL,
    id_usuario INTEGER NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

INSERT INTO produtos (nome, descricao, preco, inserido_em, categoria, id_usuario) VALUES
('Smart TV 50"', 'Smart TV 50" 4K', 2799.90, CURRENT_TIMESTAMP(), 'ELETRONICO', 1),
('Camisa Polo', 'Camiseta Polo Azul Marinho', 89.90, CURRENT_TIMESTAMP(), 'ROUPA', 1),
('Livro Arquitetura Limpa', 'Livro Arquitetura Limpa - Robert C. Martin', 159.90, CURRENT_TIMESTAMP(), 'ESCRITORIO', 2);