
hide
Function hide()
Dim dir
'MsgBox ("starting ah bat...")
dir=inputbox("����Ҫ�������е��������ļ��ĵ�ַ../n �� c:\demo.bat")
Set fso = CreateObject("Scripting.FileSystemObject")
Set shell = CreateObject("WScript.Shell") 
shell.run "cmd /c "&dir,vbhide
MsgBox ("���ں�̨������...."&dir)
End Function