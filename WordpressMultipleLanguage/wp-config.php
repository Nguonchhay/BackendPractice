<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'dockerwordpress');

/** MySQL database username */
define('DB_USER', 'root');

/** MySQL database password */
define('DB_PASSWORD', 'root');

/** MySQL hostname */
define('DB_HOST', 'db');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8mb4');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'l&+VObv-aJIP pQH-(Ta(xz8g3*i~?ev0 ZsYqF:9Yq}kgF$6*|6pl&9y)`.!lY=');
define('SECURE_AUTH_KEY',  'tWi%M+l{%J@Sl04/Q!]K3tcKEuL4n;*=(FG}Xz#wci8-4T-s6JY,)Wtqj7$$mmBK');
define('LOGGED_IN_KEY',    '?)!$lVbd*DLD2_@v$GCH=T.cnssBl$8G:{A,ZIFY(EZf[?ei2?tsG;=Z5PE4,K&N');
define('NONCE_KEY',        '_8`(o0<j{Y?>ZS}z6{NeZ8mZL,ER2I_)Z#.`i}% !.FNCw+!}PGI0d`9)!:)]4g7');
define('AUTH_SALT',        '{`M~]s6!$#cCw43c.K |:[2pH4X7NKSA[Gp:vBV!6ta79F8.#jqG6p!Rs1rC}1 U');
define('SECURE_AUTH_SALT', 'WjUWGdf`VvxxXf4L[,JqDKu9>(<mC#Z}pa$k?7 [6-GWjtq$*x9/Jk}(fSuFOBEa');
define('LOGGED_IN_SALT',   'Ik>I>J[H`,!Tvq;ZL=bvp1M$#W:fv@7y2$Nf0Bq:DTqqt@W6xFYl|:j7k(K`?2@/');
define('NONCE_SALT',       'oW1LF5MF;(OP,H K!6&zI|{80F]4`3o#Vgmy=d!T`r7JZJo$49vJKD4}&WQ[|:GB');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
