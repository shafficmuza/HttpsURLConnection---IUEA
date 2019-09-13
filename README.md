# HttpsURLConnection-IUEA
Android Network Operations Uning HttpsURLConnection.

Sent Data from Android UI to MySql Database on the HTTPS Server using PHP as the Server side.

you need to point your connection parameters to a server of your choice and change the PHP Config File.
Create a database on you Server.

Database: `smsvibe_iuea`
--

-- --------------------------------------------------------

-- Create table on your server
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `semester` varchar(10) DEFAULT NULL,
  `year` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

