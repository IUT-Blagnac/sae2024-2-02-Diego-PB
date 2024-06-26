def RLE(chaine :str ) -> str:
    nvlchaine = ""
    cpt = 1
    for i in range(len(chaine)):
        if i<len(chaine)-1 and chaine[i] == chaine[i+1] and cpt<9: 
            cpt=cpt+1
        else :
            nvlchaine = nvlchaine + str(cpt) + chaine[i]
            cpt = 1
    return nvlchaine



def RLEit(chaine :str, iteration:int) -> str:
    if iteration != 1 :
        nvlchaine = RLE(chaine)
        return RLEit(nvlchaine,iteration-1)  #Pour la récursivité on enleve 1 jusqua que ce soit égale à 1
    return RLE(chaine)
    


def unRLE(chaine : str)->str:
    nvlchaine = ""
    for i in range(0,len(chaine),2):
        nvlchaine = nvlchaine + int(chaine[i])*chaine[i+1]    
    return nvlchaine


def unRLEit(chaine :str, iteration:int) -> str:
    if iteration != 1 :
        nvlchaine = unRLE(chaine)
        return unRLEit(nvlchaine,iteration-1) #Pour la récursivité on enleve 1 jusqua que ce soit égale à 1
    return unRLE(chaine)

# *************************************************************** ********************************************
# *************************************** Zone de test de l'algorithme ***************************************
# ************************************************************************************************************

chaineEntree = ""

print(RLE(chaineEntree))

def test_RLE():
    assert RLE("") == ""
    assert RLE("abc") == "1a1b1c"
    assert RLE("abbccc") == "1a2b3c"
    assert RLE("aaabaa") == "3a1b2a"
    assert RLE("aAa") == "1a1A1a"
    assert RLE("WWWWWWWWWWWWW") == "9W4W"

test_RLE()

print("Test RLE réussi")

# *************************************************************** ********************************************
# *************************************** Zone de test de l'algorithme ***************************************
# ************************************************************************************************************