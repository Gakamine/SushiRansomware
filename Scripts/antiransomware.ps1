$files = Get-ChildItem "C:\Users\IEUser\Desktop\MalwareDatabase-master\MalwareDatabase-master\ransomwares\exe" -Recurse

foreach ($f in $files){
    $file = "C:\Users\IEUser\Desktop\MalwareDatabase-master\MalwareDatabase-master\ransomwares\exe\"+$f
    $hash = Get-FileHash $file | Select-Object Hash
    $url = "query=get_info&hash='$hash'"
    wget --post-data $url https://mb-api.abuse.ch/api/v1
}