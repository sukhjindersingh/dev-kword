
hide
Function hide()
Dim dir
'MsgBox ("starting ah bat...")
dir=inputbox("输入要隐藏运行的批处理文件的地址../n 如 c:\demo.bat")
Set fso = CreateObject("Scripting.FileSystemObject")
Set shell = CreateObject("WScript.Shell") 
shell.run "cmd /c "&dir,vbhide
MsgBox ("已在后台运行中...."&dir)
End Function