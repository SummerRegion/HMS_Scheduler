@echo off
setlocal ENABLEEXTENSIONS
setlocal ENABLEDELAYEDEXPANSION

rem set DIRS=%*
rem set PATHTYPE=
rem for %%A IN (%*) do (
rem 	echo %%A %%~aA
rem )

set DIR=
set PATHTYPE=
for /f "tokens=1-9" %%A IN (%1) do (
	set DIR=%%A
	set PATHTYPE=%%~aA
	echo !DIR! !PATHTYPE!
	if "%%~aA"=="d----------" ( call :process_dir %%A ) else ( call :process_file %%A )
	rem set DIR=%%B
	rem set PATHTYPE=%%~aB
	rem echo !DIR! !PATHTYPE!
	
	rem set DIR=%%B
	rem set PATHTYPE=%%~aB
	rem echo !DIR! !PATHTYPE!
	
)

:process_dir
echo process_dir %1
goto:eof

:process_file
echo process_file %1
goto:eof