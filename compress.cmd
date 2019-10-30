@echo off
setlocal ENABLEEXTENSIONS
setlocal ENABLEDELAYEDEXPANSION
echo Compressing Javascript Files
set CO=WHITESPACE_ONLY
set BATCH_DIR=%~dp0
set CLOSURE_COMPILER_PATH=%BATCH_DIR%\lib\closure-compiler.jar
if not exist %CLOSURE_COMPILER_PATH% (
	echo Closure compiler can't be found in %CLOSURE_COMPILER_PATH%
	goto:eof
)
rem echo %*
rem for %%A IN (%*) do (
rem 	echo %%~aA
rem 	if "%%~aA"=="d----------" ( call :process_dir %%A ) else ( call :process_file %%A )
rem )
for /f "tokens=1-9" %%A IN (%1) do (
	rem echo %%A %%~aA
	rem if "%%~aA"=="d----------" ( call :process_dir %%A ) else ( call :process_file %%A )
	call :process_dir %%A
)
echo Finished Compressing Javascript Files
goto:eof

:process_dir
echo Process directory %1, absolute path %BATCH_DIR%%1
if not exist %BATCH_DIR%%1 ( 
	echo %BATCH_DIR%%1 does not exists 
) else (
	set TARGET_DIR=%BATCH_DIR%%1 
	echo target dir !TARGET_DIR!
	if not exist !TARGET_DIR! mkdir !TARGET_DIR!
	cd !TARGET_DIR!
	rem compress each files
	call :rtrim TARGET_DIR
	del *.min.js
	dir /b /a-d *.js >> jsfiles.txt
	for /f %%F in (jsfiles.txt) do (
		echo process file %%F at !TARGET_DIR!\%%F, output file !TARGET_DIR!\%%~nF.min%%~xF
		rem if exist !TARGET_DIR!\%%~nF.min%%~xF del /F /Q !TARGET_DIR!\%%~nF.min%%~xF
		java -jar %CLOSURE_COMPILER_PATH% --compilation_level %CO% --js !TARGET_DIR!\%%F --js_output_file !TARGET_DIR!\%%~nF.min%%~xF
		del !TARGET_DIR!\%%F
	)
	del jsfiles.txt
)
goto:eof

:process_file
echo Process file %1, absolute path %BATCH_DIR%%1
if not exist %BATCH_DIR%%1 ( 
	echo %BATCH_DIR%%1 does not exists 
) else ( 
	set TARGET_FILE_PATH=%BATCH_DIR%%1
	echo process file !TARGET_FILE_PATH!, output file !TARGET_FILE_PATH:%~nx1=%~n1.min%~x1!
	java -jar %CLOSURE_COMPILER_PATH% --compilation_level %CO% --js %BATCH_DIR%%1 --js_output_file !TARGET_FILE_PATH:%~nx1=%~n1.min%~x1!	
)
goto:eof

:rtrim
call set string=%%%~1%%
set char=%~2
set max=%~3
if "%char%"=="" set char= &rem one space
if "%max%"=="" set max=32
for /l %%a in (1,1,%max%) do if "!string:~-1!"=="%char%" set string=!string:~0,-1!
if "%~1" neq "" set %~1=%string%
goto:eof
