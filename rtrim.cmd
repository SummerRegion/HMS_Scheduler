:rTrim string char max -- strips white spaces (or other characters) from the end of a string
::                     -- string [in,out] - string variable to be trimmed
::                     -- char   [in,opt] - character to be trimmed, default is space
::                     -- max    [in,opt] - maximum number of characters to be trimmed from the end, default is 32
:$created 20060101 :$changed 20080219 :$categories StringManipulation
:$source http://www.dostips.com
SETLOCAL ENABLEDELAYEDEXPANSION
call set string=%%%~1%%
set char=%~2
set max=%~3
if "%char%"=="" set char= &rem one space
if "%max%"=="" set max=32
for /l %%a in (1,1,%max%) do if "!string:~-1!"=="%char%" set string=!string:~0,-1!
( ENDLOCAL & REM RETURN VALUES
    IF "%~1" NEQ "" SET %~1=%string%
)
EXIT /b