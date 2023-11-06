CREATE DATABASE PRJ_Project;

CREATE TABLE [dbo].[User](
	[UserID] [int] Primary Key NOT NULL,
	[FirstName] [nvarchar](40) NOT NULL,
	[LastName] [nvarchar](40) NOT NULL,
	[Account] [nvarchar](40) NOT NULL,
	[Password] [nvarchar](40) NOT NULL,
	[Email] [nvarchar](40) NOT NULL,
	[Phone] [nvarchar](20) NOT NULL, 
)

CREATE TABLE [dbo].[Product](
	[ProductID] [int] Primary Key NOT NULL,
	[ProductName] [nvarchar](40) NOT NULL,
	[Weight] [float] NOT NULL,
	[StartDate] [date] NOT NULL,
	[EndDate] [date] NOT NULL,
	[Price] [float] NOT NULL,
)

CREATE TABLE [dbo].[Order](
	UserID INT references [dbo].[User](UserID),
	ProductID INT references [dbo].[Product](ProductID),
	Price float,
	[Amount] [nvarchar](40) NOT NULL,
	[TotalPrice] [int] NOT NULL
)


GO
INSERT [dbo].[User] ([UserID], [FirstName], [LastName], [Account], [Password], [Email], [Phone]) VALUES (1, N'Tran', N'Thang', N'thang123', N'e10adc3949ba59abbe56e057f20f883e', N'tranthang123@gmail.com', N'0362336362')
INSERT [dbo].[User] ([UserID], [FirstName], [LastName], [Account], [Password], [Email], [Phone]) VALUES (2, N'Nguyen', N'Khoi', N'nkhoi123', N'e10adc3949ba59abbe56e057f20f883e', N'nguyenkhoi123@gmail.com', N'0384077921')
INSERT [dbo].[User] ([UserID], [FirstName], [LastName], [Account], [Password], [Email], [Phone]) VALUES (3, N'Hoang', N'Phuong', N'phuong123', N'e10adc3949ba59abbe56e057f20f883e', N'hoangphuong123@gmail.com', N'0326776754')
INSERT [dbo].[User] ([UserID], [FirstName], [LastName], [Account], [Password], [Email], [Phone]) VALUES (4, N'Huynh', N'Sieu', N'sieu123', N'e10adc3949ba59abbe56e057f20f883e', N'huynhsieu123@gmail.com', N'0366230497')


GO
INSERT [dbo].[Product] ([ProductID], [ProductName], [Weight], [StartDate], [EndDate], [Price]) VALUES (1, N'Mango', 1, '1/1/2023', '1/3/2023', 2.99)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Weight], [StartDate], [EndDate], [Price]) VALUES (2, N'Apple', 0.5, '1/1/2023', '1/6/2023', 5.99)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Weight], [StartDate], [EndDate], [Price]) VALUES (3, N'Dragon Fruit', 2, '1/1/2023', '1/5/2023', 3.49)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Weight], [StartDate], [EndDate], [Price]) VALUES (4, N'Strawberry', 1.5, '1/1/2023', '1/2/2023', 1.99)



