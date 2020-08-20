USE [ThymeleafCrud]
GO

/****** Object:  Table [dbo].[book] ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[book](
	[bookid] [int]  NOT NULL,
	[name] [varchar](255) NULL,
	[author] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[bookid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[book] ADD  DEFAULT (NULL) FOR [name]
GO

ALTER TABLE [dbo].[book] ADD  DEFAULT (NULL) FOR [author]
GO


