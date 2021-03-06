CREATE DATABASE [Photographer]
GO
USE [Photographer]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 4/21/2020 9:44:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[address] [nvarchar](max) NULL,
	[city] [nvarchar](max) NULL,
	[country] [nvarchar](max) NULL,
	[tel] [nvarchar](50) NULL,
	[email] [nvarchar](max) NULL,
	[image_main] [nvarchar](max) NULL,
	[name_image] [nvarchar](max) NULL,
	[map] [nvarchar](max) NULL,
	[about] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Gallery]    Script Date: 4/21/2020 9:44:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gallery](
	[gallery_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](max) NULL,
	[name] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
 CONSTRAINT [PK_Gallery] PRIMARY KEY CLUSTERED 
(
	[gallery_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 4/21/2020 9:44:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[gallery_id] [int] NULL,
	[image] [nvarchar](max) NULL,
 CONSTRAINT [PK_Image] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Contact] ([address], [city], [country], [tel], [email], [image_main], [name_image], [map], [about]) VALUES (N'Thuỷ Nguyên', N'Hải Phòng', N'Viet Nam', N'125348465', N'datdthe130593@fpt.edu.vn', N'img5.jpg', N'Lorem ipsum dolor sit amet', N'map.png', N'
Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim')
SET IDENTITY_INSERT [dbo].[Gallery] ON 

INSERT [dbo].[Gallery] ([gallery_id], [title], [name], [description]) VALUES (1, N'View Gallery 1', N'Gallery 1', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([gallery_id], [title], [name], [description]) VALUES (2, N'View Gallery 2', N'Gallery 2', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([gallery_id], [title], [name], [description]) VALUES (3, N'View Gallery 3', N'Gallery 3', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([gallery_id], [title], [name], [description]) VALUES (4, N'View Gallery 4', N'Gallery 4', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([gallery_id], [title], [name], [description]) VALUES (5, N'View Gallery 5', N'Gallery 5', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([gallery_id], [title], [name], [description]) VALUES (8, N'View Gallery 6', N'Gallery 6', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([gallery_id], [title], [name], [description]) VALUES (9, N'View Gallery 7', N'Gallery 7', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
SET IDENTITY_INSERT [dbo].[Gallery] OFF
SET IDENTITY_INSERT [dbo].[Image] ON 

INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (1, 1, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (2, 1, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (3, 1, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (4, 1, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (5, 1, N'img5.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (6, 1, N'img6.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (7, 1, N'img7.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (8, 1, N'img8.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (9, 2, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (10, 2, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (11, 2, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (12, 2, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (13, 2, N'img5.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (14, 2, N'img6.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (15, 2, N'img7.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (16, 2, N'img8.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (17, 3, N'img8.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (18, 3, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (19, 3, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (20, 3, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (21, 3, N'img5.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (22, 3, N'img6.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (23, 3, N'img7.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (24, 3, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (25, 4, N'img8.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (26, 4, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (27, 4, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (28, 4, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (29, 4, N'img5.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (30, 4, N'img6.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (31, 4, N'img7.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (32, 4, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (33, 5, N'img8.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (34, 5, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (35, 5, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (36, 5, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (37, 5, N'img5.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (38, 5, N'img6.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (39, 5, N'img7.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (40, 5, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (41, 8, N'img8.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (42, 8, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (43, 8, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (44, 8, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (45, 8, N'img5.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (46, 8, N'img6.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (47, 8, N'img7.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (48, 8, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (49, 8, N'img8.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (50, 9, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (51, 9, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (52, 9, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (53, 9, N'img5.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (54, 9, N'img6.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (55, 9, N'img7.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (56, 9, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (57, 1, N'img1.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (58, 1, N'img2.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (59, 1, N'img3.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (60, 1, N'img4.jpg')
INSERT [dbo].[Image] ([id], [gallery_id], [image]) VALUES (61, 1, N'img4.jpg')
SET IDENTITY_INSERT [dbo].[Image] OFF
ALTER TABLE [dbo].[Image]  WITH CHECK ADD  CONSTRAINT [FK_Image_Gallery] FOREIGN KEY([gallery_id])
REFERENCES [dbo].[Gallery] ([gallery_id])
GO
ALTER TABLE [dbo].[Image] CHECK CONSTRAINT [FK_Image_Gallery]
GO
