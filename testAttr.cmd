@echo off
setlocal ENABLEEXTENSIONS
setlocal ENABLEDELAYEDEXPANSION
for %%A IN (%*) do ( 
	echo %%~aA
	if "%%~aA"=="d----------" call :process_dir %%A
	
)
