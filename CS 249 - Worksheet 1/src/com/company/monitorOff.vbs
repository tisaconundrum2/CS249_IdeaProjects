Private Declare Function SendMessage Lib "user32" Alias "SendMessageA" _ 
    (ByVal hWnd As Long, ByVal wMsg As Long, ByVal wParam As Long, _ 
     ByVal lParam As Long) As Long 
Private Const WM_SYSCOMMAND = &H112& 
Private Const SC_MONITORPOWER = &HF170& 
Private lRet As Long 
Public Sub monitorStandby() 
    lRet = SendMessage(frmStandby.hWnd, WM_SYSCOMMAND, SC_MONITORPOWER, 1&) 
End Sub 
