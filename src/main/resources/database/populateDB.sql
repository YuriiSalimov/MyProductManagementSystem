USE productManagementDB;

INSERT INTO `products` (`id`, `title`, `manufacturer`, `description`, `cost`) VALUES
  (1, 'Title 1', 'manufacturer 1', 'description 1', 101),
  (2, 'Title 2', 'manufacturer 2', 'description 2', 102),
  (3, 'Title 3', 'manufacturer 3', 'description 3', 103),
  (4, 'Title 4', 'manufacturer 4', 'description 4', 104),
  (5, 'Title 5', 'manufacturer 5', 'description 5', 105);

INSERT INTO `users` (`id`, `username`, `password`, `role`, `locked`) VALUES
  (1, 'admin', 'admin', 'ADMIN', '\0'),
  (2, 'client', 'client', 'USER', '');
