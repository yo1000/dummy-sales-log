-- item

CREATE TABLE item(
    "id" integer PRIMARY KEY,
    "name" varchar NOT NULL,
    "price" integer,
    "sell_price" integer
);

INSERT INTO item("id", "name", "price", "sell_price") VALUES(0, '', null, null);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(1, 'Potion', 100, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(2, 'Potion+', null, 100);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(3, 'Hi-Potion', 500, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(4, 'Hi-Potion+', null, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(5, 'X-Potion', 5000, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(6, 'Mega-Potion', 10000, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(7, 'Phoenix Down', 500, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(8, 'Mega Phoenix', 10000, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(9, 'Elixir', 50000, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(10, 'Megalixir', null, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(11, 'Antidote', 100, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(12, 'Soft', 100, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(13, 'Eye Drops', 100, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(14, 'Echo Screen', 100, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(15, 'Holy Water', 100, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(16, 'Remedy', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(17, 'Remedy+', null, 1000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(18, 'Hero-trial', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(19, 'Hero', null, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(20, 'Holy War-trial', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(21, 'Holy War', null, 10000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(22, 'Shell Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(23, 'Protect Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(24, 'Aura Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(25, 'Death Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(26, 'Holy Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(27, 'Flare Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(28, 'Meteor Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(29, 'Ultima Stone', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(30, 'Gysahl Greens', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(31, 'Phoenix Pinion', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(32, 'Friendship', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(33, 'Tent', 1000, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(34, 'Pet House', 1000, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(35, 'Cottage', 1800, 450);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(36, 'G-Potion', 200, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(37, 'G-Hi-Potion', 600, 150);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(38, 'G-Mega-Potion', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(39, 'G-Returner', 500, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(40, 'Rename Card', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(41, 'Amnesia Greens', 1000, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(42, 'HP-J Scroll', 10000, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(43, 'Str-J Scroll', 10000, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(44, 'Vit-J Scroll', 10000, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(45, 'Mag-J Scroll', 10000, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(46, 'Spr-J Scroll', 10000, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(47, 'Spd-J Scroll', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(48, 'Luck-J Scroll', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(49, 'Aegis Shield', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(50, 'Elem Atk', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(51, 'Elem Guard', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(52, 'Status Atk', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(53, 'Status Guard', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(54, 'Rosetta Stone', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(55, 'Magic Scroll', 5000, 1250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(56, 'GF Scroll', 5000, 1250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(57, 'Draw Scroll', 5000, 1250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(58, 'Item Scroll', 5000, 1250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(59, 'Gambler Spirit', null, 1250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(60, 'Healing Ring', null, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(61, 'Phoenix Spirit', null, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(62, 'Med Kit', null, 2500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(63, 'Bomb Spirit', null, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(64, 'Hungry Cookpot', null, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(65, 'Mog''s Amulet', null, 1250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(66, 'Steel Pipe', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(67, 'Star Fragment', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(68, 'Energy Crystal', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(69, 'Samantha Soul', null, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(70, 'Healing Mail', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(71, 'Silver Mail', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(72, 'Gold Armor', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(73, 'Diamond Armor', null, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(74, 'Regen Ring', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(75, 'Giant''s Ring', 20000, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(76, 'Gaea''s Ring', null, 7500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(77, 'Strength Love', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(78, 'Power Wrist', 20000, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(79, 'Hyper Wrist', null, 7500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(80, 'Turtle Shell', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(81, 'Orihalcon', 20000, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(82, 'Adamantine', null, 7500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(83, 'Rune Armlet', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(84, 'Force Armlet', 20000, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(85, 'Magic Armlet', null, 7500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(86, 'Circlet', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(87, 'Hypno Crown', 20000, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(88, 'Royal Crown', null, 7500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(89, 'Jet Engine', null, 5000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(90, 'Rocket Engine', null, 7500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(91, 'Moon Curtain', null, 10000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(92, 'Steel Curtain', null, 10000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(93, 'Glow Curtain', null, 10000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(94, 'Accelerator', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(95, 'Monk''s Code', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(96, 'Knight''s Code', null, 10000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(97, 'Doc''s Code', null, 10000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(98, 'Hundred Needles', null, 10000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(99, 'Three Stars', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(100, 'Ribbon', null, 25000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(101, 'Normal Ammo', 20, 1);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(102, 'Shotgun Ammo', 40, 2);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(103, 'Dark Ammo', 300, 15);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(104, 'Fire Ammo', 500, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(105, 'Demolition Ammo', 800, 40);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(106, 'Fast Ammo', 100, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(107, 'AP Ammo', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(108, 'Pulse Ammo', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(109, 'M-Stone Piece', null, 5);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(110, 'Magic Stone', null, 12);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(111, 'Wizard Stone', null, 20);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(112, 'Ochu Tentacle', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(113, 'Healing Water', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(114, 'Cockatrice Pinion', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(115, 'Zombie Powder', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(116, 'Lightweight', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(117, 'Sharp Spike', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(118, 'Screw', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(119, 'Saw Blade', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(120, 'Mesmerize Blade', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(121, 'Vampire Fang', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(122, 'Fury Fragment', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(123, 'Betrayal Sword', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(124, 'Sleep Powder', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(125, 'Life Ring', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(126, 'Dragon Fang', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(127, 'Spider Web', null, 50);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(128, 'Coral Fragment', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(129, 'Curse Spike', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(130, 'Black Hole', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(131, 'Water Crystal', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(132, 'Missile', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(133, 'Mystery Fluid', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(134, 'Running Fire', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(135, 'Inferno Fang', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(136, 'Malboro Tentacle', null, 100);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(137, 'Whisper', null, 100);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(138, 'Laser Cannon', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(139, 'Barrier', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(140, 'Power Generator', null, 200);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(141, 'Dark Matter', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(142, 'Bomb Fragment', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(143, 'Red Fang', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(144, 'Arctic Wind', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(145, 'North Wind', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(146, 'Dynamo Stone', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(147, 'Shear Feather', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(148, 'Venom Fang', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(149, 'Steel Orb', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(150, 'Moon Stone', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(151, 'Dino Bone', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(152, 'Windmill', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(153, 'Dragon Skin', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(154, 'Fish Fin', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(155, 'Dragon Fin', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(156, 'Silence Powder', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(157, 'Poison Powder', null, 25);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(158, 'Dead Spirit', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(159, 'Chef''s Knife', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(160, 'Cactus Thorn', null, 75);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(161, 'Shaman Stone', null, 1250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(162, 'Fuel', 3000, 750);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(163, 'The Girl Next Door', null, 12500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(164, 'Sorceress'' Letter', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(165, 'Chocobo''s Tag', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(166, 'Pet Nametag', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(167, 'Solomon Ring', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(168, 'Magical Lamp', null, 125);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(169, 'HP Up', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(170, 'Str Up', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(171, 'Vit Up', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(172, 'Mag Up', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(173, 'Spr Up', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(174, 'Spd Up', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(175, 'Luck Up', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(176, 'LuvLuv G', null, 250);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(177, 'Weapons Mon 1st', 50000, 25000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(178, 'Weapons Mon Mar', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(179, 'Weapons Mon Apr', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(180, 'Weapons Mon May', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(181, 'Weapons Mon Jun', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(182, 'Weapons Mon Jul', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(183, 'Weapons Mon Aug', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(184, 'Combat King 001', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(185, 'Combat King 002', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(186, 'Combat King 003', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(187, 'Combat King 004', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(188, 'Combat King 005', 30000, 15000);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(189, 'Pet Pals Vol. 1', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(190, 'Pet Pals Vol. 2', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(191, 'Pet Pals Vol. 3', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(192, 'Pet Pals Vol. 4', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(193, 'Pet Pals Vol. 5', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(194, 'Pet Pals Vol. 6', 1000, 500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(195, 'Occult Fan I', 35000, 17500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(196, 'Occult Fan II', 35000, 17500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(197, 'Occult Fan III', null, 17500);
INSERT INTO item("id", "name", "price", "sell_price") VALUES(198, 'Occult Fan IV', null, 20000);

-- weapon

CREATE TABLE weapon(
    "id" integer PRIMARY KEY,
    "name" varchar NOT NULL,
    "price" integer,
    "str" integer NOT NULL,
    "hit" integer NOT NULL
);

INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(0, 'Revolver', 100, 11, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(1, 'Shear Trigger', 200, 14, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(2, 'Cutting Trigger', 400, 18, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(3, 'Flame Saber', 600, 20, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(4, 'Twin Lance', 800, 22, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(5, 'Punishment', 1000, 24, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(6, 'Lion Heart', 2000, 30, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(7, 'Metal Knuckle', 100, 12, 98);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(8, 'Maverick', 200, 15, 99);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(9, 'Gauntlet', 400, 20, 101);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(10, 'Ehrgeiz', 800, 25, 103);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(11, 'Valiant', 100, 12, 105);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(12, 'Ulysses', 200, 15, 108);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(13, 'Bismarck', 400, 20, 110);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(14, 'Exeter', 800, 25, 115);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(15, 'Chain Whip', 100, 12, 103);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(16, 'Slaying Tail', 200, 15, 104);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(17, 'Red Scorpion', 400, 20, 105);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(18, 'Save the Queen', 800, 25, 107);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(19, 'Pinwheel', 100, 11, 99);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(20, 'Valkyrie', 200, 14, 101);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(21, 'Rising Sun', 400, 18, 103);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(22, 'Cardinal', 800, 24, 104);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(23, 'Shooting Star', 1000, 28, 107);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(24, 'Flail', 100, 12, 98);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(25, 'Morning Star', 200, 15, 99);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(26, 'Crescent Wish', 400, 20, 100);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(27, 'Strange Vision', 800, 25, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(28, 'Hyperion', null, 12, 255);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(29, 'None', null, 20, 97);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(30, 'Machine Gun', null, 14, 103);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(31, 'Katal', null, 13, 102);
INSERT INTO weapon("id", "name", "price", "str", "hit") VALUES(32, 'Harpoon', null, 16, 98);

CREATE TABLE weapon_remodel(
    "id" integer PRIMARY KEY,
    "weapon_id" integer NOT NULL,
    "item_id" integer NOT NULL,
    "quantity" integer NOT NULL,
    FOREIGN KEY ("weapon_id") REFERENCES weapon("id"),
    FOREIGN KEY ("item_id") REFERENCES item("id")
);

-- Revolver
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(1, 0, 109, 6);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(2, 0, 118, 2);

-- Shear Trigger
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(3, 1, 66, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(4, 1, 118, 4);

-- Cutting Trigger
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(5, 2, 120, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(6, 2, 118, 8);

-- Flame Saber
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(7, 3, 123, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(8, 3, 80, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(9, 3, 118, 4);

-- Twin Lance
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(10, 4, 151, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(11, 4, 143, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(12, 4, 118, 12);

-- Punishment
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(13, 5, 159, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(14, 5, 67, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(15, 5, 80, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(16, 5, 118, 8);

-- Lion Heart
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(17, 6, 82, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(18, 6, 126, 4);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(19, 6, 108, 12);


-- Metal Knuckle
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(41, 7, 154, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(42, 7, 109, 4);

-- Maverick
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(43, 8, 155, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(44, 8, 127, 1);

-- Gauntlet
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(45, 9, 153, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(46, 9, 122, 1);

-- Ehrgeiz
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(47, 10, 82, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(48, 10, 153, 4);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(49, 10, 122, 1);


-- Valiant
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(60, 11, 66, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(61, 11, 118, 4);

-- Ulysses
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(62, 12, 66, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(63, 12, 127, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(64, 12, 118, 2);

-- Bismarck
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(65, 13, 66, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(66, 13, 146, 4);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(67, 13, 118, 8);

-- Exeter
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(68, 14, 151, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(69, 14, 150, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(70, 14, 67, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(71, 14, 118, 18);


-- Chain Whip
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(32, 15, 109, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(33, 15, 127, 1);

-- Slaying Tail
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(34, 16, 110, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(35, 16, 117, 1);

-- Red Scorpion
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(36, 17, 112, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(37, 17, 153, 2);

-- Save the Queen
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(38, 18, 136, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(39, 18, 117, 4);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(40, 18, 68, 4);


-- Pinwheel
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(20, 19, 109, 3);

-- Valkyrie
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(21, 20, 147, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(22, 20, 110, 1);

-- Rising Sun
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(23, 21, 119, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(24, 21, 118, 8);

-- Cardinal
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(25, 22, 114, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(26, 22, 120, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(27, 22, 117, 1);

-- Shooting Star
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(28, 23, 152, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(29, 23, 82, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(30, 23, 84, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(31, 23, 68, 2);


-- Flail
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(50, 24, 109, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(51, 24, 127, 1);

-- Morning Star
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(52, 25, 149, 2);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(53, 25, 117, 2);

-- Crescent Wish
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(54, 26, 135, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(55, 26, 125, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(56, 26, 117, 4);

-- Strange Vision
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(57, 27, 82, 1);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(58, 27, 67, 3);
INSERT INTO weapon_remodel("id", "weapon_id", "item_id", "quantity") VALUES(59, 27, 153, 2);


-- element

CREATE TABLE element(
    "id" integer PRIMARY KEY,
    "name" varchar NOT NULL
);

INSERT INTO element("id", "name") VALUES(1, 'Fire');
INSERT INTO element("id", "name") VALUES(2, 'Ice');
INSERT INTO element("id", "name") VALUES(3, 'Thunder');
INSERT INTO element("id", "name") VALUES(4, 'Earth');
INSERT INTO element("id", "name") VALUES(5, 'Poison');
INSERT INTO element("id", "name") VALUES(6, 'Wind');
INSERT INTO element("id", "name") VALUES(7, 'Water');
INSERT INTO element("id", "name") VALUES(8, 'Holy');


-- card

CREATE TABLE card(
    "id" integer PRIMARY KEY,
    "name" varchar NOT NULL,
    "level" integer NOT NULL,
    "element_id" integer,
    "top" integer NOT NULL,
    "right" integer NOT NULL,
    "bottom" integer NOT NULL,
    "left" integer NOT NULL
);

INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(1, 'Geezard', 1, null, 1, 4, 1, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(2, 'Funguar', 1, null, 5, 1, 1, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(3, 'Bite Bug', 1, null, 1, 3, 3, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(4, 'Red Bat', 1, null, 6, 1, 1, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(5, 'Blobra', 1, null, 2, 3, 1, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(6, 'Gayla', 1, 3, 2, 1, 4, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(7, 'Gesper', 1, null, 1, 5, 4, 1);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(8, 'Fastitocalon-F', 1, 4, 3, 5, 2, 1);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(9, 'Blood Soul', 1, null, 2, 1, 6, 1);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(10, 'Caterchipillar', 1, null, 4, 2, 4, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(11, 'Cockatrice', 1, 3, 2, 1, 2, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(12, 'Grat', 2, null, 7, 1, 3, 1);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(13, 'Buel', 2, null, 6, 2, 2, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(14, 'Mesmerize', 2, null, 5, 3, 3, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(15, 'Glacial Eye', 2, 2, 6, 1, 4, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(16, 'Belhelmel', 2, null, 3, 4, 5, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(17, 'Thrustaevis', 2, 6, 5, 3, 2, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(18, 'Anacondaur', 2, 5, 5, 1, 3, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(19, 'Creeps', 2, 3, 5, 2, 5, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(20, 'Grendel', 2, 3, 4, 4, 5, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(21, 'Jelleye', 2, null, 3, 2, 1, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(22, 'Grand Mantis', 2, null, 5, 2, 5, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(23, 'Forbidden', 3, null, 6, 6, 3, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(24, 'Armadodo', 3, 4, 6, 3, 1, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(25, 'Tri-Face', 3, 5, 3, 5, 5, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(26, 'Fastitocalon', 3, 4, 7, 5, 1, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(27, 'Snow Lion', 3, 2, 7, 1, 5, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(28, 'Ochu', 3, null, 5, 6, 3, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(29, 'SAM08G', 3, 1, 5, 6, 2, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(30, 'Death Claw', 3, 1, 4, 4, 7, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(31, 'Cactuar', 3, null, 6, 2, 6, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(32, 'Tonberry', 3, null, 3, 6, 4, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(33, 'Abyss Worm', 3, 4, 7, 2, 3, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(34, 'Turtapod', 4, null, 2, 3, 6, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(35, 'Vysage', 4, null, 6, 5, 4, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(36, 'T-Rexaur', 4, null, 4, 6, 2, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(37, 'Bomb', 4, 1, 2, 7, 6, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(38, 'Blitz', 4, 3, 1, 6, 4, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(39, 'Wendigo', 4, null, 7, 3, 1, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(40, 'Torama', 4, null, 7, 4, 4, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(41, 'Imp', 4, null, 3, 7, 3, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(42, 'Blue Dragon', 4, 5, 6, 2, 7, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(43, 'Adamantoise', 4, 4, 4, 5, 5, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(44, 'Hexadragon', 4, 1, 7, 5, 4, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(45, 'Iron Giant', 5, null, 6, 5, 6, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(46, 'Behemoth', 5, null, 3, 6, 5, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(47, 'Chimera', 5, 7, 7, 6, 5, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(48, 'PuPu', 5, null, 3, 10, 2, 1);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(49, 'Elastoid', 5, null, 6, 2, 6, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(50, 'GIM47N', 5, null, 5, 5, 7, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(51, 'Malboro', 5, 5, 7, 7, 4, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(52, 'Ruby Dragon', 5, 1, 7, 2, 7, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(53, 'Elnoyle', 5, null, 5, 3, 7, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(54, 'Tonberry King', 5, null, 4, 6, 7, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(55, 'Wedge, Biggs', 5, null, 6, 6, 2, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(56, 'Fujin, Raijin', 6, null, 2, 8, 8, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(57, 'Elvoret', 6, 6, 7, 8, 3, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(58, 'X-ATM092', 6, null, 4, 8, 7, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(59, 'Granaldo', 6, null, 7, 2, 8, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(60, 'Gerogero', 6, 5, 1, 8, 8, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(61, 'Iguion', 6, null, 8, 2, 8, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(62, 'Abadon', 6, null, 6, 8, 4, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(63, 'Trauma', 6, null, 4, 8, 5, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(64, 'Oilboyle', 6, null, 1, 8, 4, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(65, 'Shumi Tribe', 6, null, 6, 5, 8, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(66, 'Krysta', 6, null, 7, 5, 8, 1);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(67, 'Propagator', 7, null, 8, 4, 4, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(68, 'Jumbo Cactuar', 7, null, 8, 8, 4, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(69, 'Tri-Point', 7, 3, 8, 5, 2, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(70, 'Gargantua', 7, null, 5, 6, 6, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(71, 'Mobile Type 8', 7, null, 8, 6, 7, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(72, 'Sphinxara', 7, null, 8, 3, 5, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(73, 'Tiamat', 7, null, 8, 8, 5, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(74, 'BGH251F2', 7, null, 5, 7, 8, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(75, 'Red Giant', 7, null, 6, 8, 4, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(76, 'Catoblepas', 7, null, 1, 8, 7, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(77, 'Ultima Weapon', 7, null, 7, 7, 2, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(78, 'Chubby Chocobo', 8, null, 4, 4, 8, 9);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(79, 'Angelo', 8, null, 9, 6, 7, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(80, 'Gilgamesh', 8, null, 3, 7, 9, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(81, 'MiniMog', 8, null, 9, 3, 9, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(82, 'Chicobo', 8, null, 9, 4, 8, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(83, 'Quezacotl', 8, 3, 2, 9, 9, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(84, 'Shiva', 8, 2, 6, 7, 4, 9);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(85, 'Ifrit', 8, 1, 9, 6, 2, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(86, 'Siren', 8, null, 8, 9, 6, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(87, 'Sacred', 8, 4, 5, 1, 9, 9);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(88, 'Minotaur', 8, 4, 9, 5, 2, 9);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(89, 'Carbuncle', 9, null, 8, 4, 10, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(90, 'Diablos', 9, null, 5, 10, 8, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(91, 'Leviathan', 9, 7, 7, 10, 1, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(92, 'Odin', 9, null, 8, 10, 3, 5);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(93, 'Pandemona', 9, 6, 10, 1, 7, 7);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(94, 'Cerberus', 9, null, 7, 4, 6, 10);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(95, 'Alexander', 9, 8, 9, 10, 4, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(96, 'Phoenix', 9, 1, 7, 2, 7, 10);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(97, 'Bahamut', 9, null, 10, 8, 2, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(98, 'Doomtrain', 9, 5, 3, 1, 10, 10);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(99, 'Eden', 9, null, 4, 4, 9, 10);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(100, 'Ward', 10, null, 10, 7, 2, 8);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(101, 'Kiros', 10, null, 6, 7, 6, 10);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(102, 'Laguna', 10, null, 5, 10, 3, 9);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(103, 'Selphie', 10, null, 10, 8, 6, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(104, 'Quistis', 10, null, 9, 6, 10, 2);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(105, 'Irvine', 10, null, 2, 6, 9, 10);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(106, 'Zell', 10, null, 8, 5, 10, 6);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(107, 'Rinoa', 10, null, 4, 10, 2, 10);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(108, 'Edea', 10, null, 10, 10, 3, 3);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(109, 'Seifer', 10, null, 6, 9, 10, 4);
INSERT INTO card("id", "name", "level", "element_id", "top", "right", "bottom", "left") VALUES(110, 'Squall', 10, null, 10, 4, 6, 9);


-- card_mod

CREATE TABLE card_mod(
    "id" integer PRIMARY KEY,
    "card_id" integer NOT NULL,
    "card_quantity" integer NOT NULL,
    "item_id" integer NOT NULL,
    "item_quantity" integer NOT NULL
);

INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(1, 1, 1, 118, 5);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(2, 2, 1, 109, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(3, 3, 1, 109, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(4, 4, 1, 121, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(5, 5, 4, 83, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(6, 6, 1, 133, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(7, 7, 1, 130, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(8, 8, 5, 131, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(9, 9, 1, 115, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(10, 10, 1, 127, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(11, 11, 1, 114, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(12, 12, 1, 110, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(13, 13, 1, 110, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(14, 14, 1, 120, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(15, 15, 1, 144, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(16, 16, 1, 119, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(17, 17, 1, 147, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(18, 18, 1, 148, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(19, 19, 1, 128, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(20, 20, 1, 155, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(21, 21, 1, 110, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(22, 22, 1, 117, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(23, 23, 1, 123, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(24, 24, 1, 151, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(25, 25, 1, 129, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(26, 26, 1, 131, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(27, 27, 1, 145, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(28, 28, 1, 112, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(29, 29, 1, 134, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(30, 30, 1, 117, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(31, 31, 1, 160, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(32, 32, 1, 159, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(33, 33, 1, 152, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(34, 34, 5, 70, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(35, 35, 1, 111, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(36, 36, 2, 151, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(37, 37, 1, 142, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(38, 38, 1, 146, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(39, 39, 1, 149, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(40, 40, 5, 125, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(41, 41, 1, 111, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(42, 42, 4, 122, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(43, 43, 3, 80, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(44, 44, 3, 143, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(45, 45, 3, 67, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(46, 46, 10, 139, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(47, 47, 10, 74, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(48, 48, 1, 64, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(49, 49, 1, 66, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(50, 50, 1, 106, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(51, 51, 4, 136, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(52, 52, 10, 135, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(53, 53, 10, 68, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(54, 54, 1, 159, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(55, 55, 1, 5, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(56, 56, 1, 5, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(57, 57, 1, 25, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(58, 58, 2, 80, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(59, 59, 1, 39, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(60, 60, 10, 86, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(61, 61, 1, 114, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(62, 62, 1, 103, 30);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(63, 63, 1, 105, 30);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(64, 64, 1, 104, 30);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(65, 65, 5, 59, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(66, 66, 1, 26, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(67, 67, 1, 38, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(68, 68, 1, 160, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(69, 69, 40, 89, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(70, 70, 10, 77, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(71, 71, 1, 22, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(72, 72, 1, 38, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(73, 73, 1, 27, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(74, 74, 1, 23, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(75, 75, 1, 28, 5);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(76, 76, 1, 40, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(77, 77, 1, 29, 1);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(78, 78, 1, 176, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(79, 79, 1, 9, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(80, 80, 1, 21, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(81, 81, 1, 34, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(82, 82, 1, 30, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(83, 83, 1, 146, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(84, 84, 1, 145, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(85, 85, 1, 50, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(86, 86, 1, 52, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(87, 87, 1, 151, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(88, 88, 1, 82, 10);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(89, 89, 1, 93, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(90, 90, 1, 130, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(91, 91, 1, 97, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(92, 92, 1, 158, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(93, 93, 1, 152, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(94, 94, 1, 116, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(95, 95, 1, 91, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(96, 96, 1, 61, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(97, 97, 1, 10, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(98, 98, 1, 53, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(99, 99, 1, 95, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(100, 100, 1, 76, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(101, 101, 1, 94, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(102, 102, 1, 19, 100);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(103, 103, 1, 51, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(104, 104, 1, 69, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(105, 105, 1, 90, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(106, 106, 1, 79, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(107, 107, 1, 85, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(108, 108, 1, 88, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(109, 109, 1, 73, 3);
INSERT INTO card_mod("id", "card_id", "card_quantity", "item_id", "item_quantity") VALUES(110, 110, 1, 99, 3);
