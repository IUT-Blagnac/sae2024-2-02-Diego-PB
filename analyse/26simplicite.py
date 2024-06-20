def RLE(input):
    if not input:
        return ""
    
    chaineCompresse = []
    nbCaracteres = 1

    taille = len(input)
    for i in range(1, taille):
        caratereActuel = input[i]
        caracterePrecedent = input[i - 1]

        if caratereActuel == caracterePrecedent:
            nbCaracteres += 1

            #Si on atteint 9 caractères identiques, on ajoute à la chaine de sortie
            if nbCaracteres == 9:
                chaineCompresse.append(f"{nbCaracteres}{caracterePrecedent}")
                nbCaracteres = 0
        else:
            chaineCompresse.append(f"{nbCaracteres}{caracterePrecedent}")
            nbCaracteres = 1
    # On ajoute le dernier groupe de caractères à la chaine
    chaineCompresse.append(f"{nbCaracteres}{caratereActuel}")

    return ''.join(chaineCompresse)

def RLE_ite(input, iteration):
    chaineCompresse = input

    for i in range(iteration):
        chaineCompresse = RLE(chaineCompresse)

    return ''.join(chaineCompresse)

def unRLE(input):
    if not input:
        return ""
    
    chaineDecompresse = []

    #Boucle sur la chaine avec un pas de 2
    for i in range(0, len(input), 2):
        nb_caracteres = int(input[i])
        caractere = input[i + 1]

        # Répéter le caractère nb_caracteres fois et l'ajouter à la chaîne de sortie
        chaineDecompresse.append(caractere * nb_caracteres)

    return ''.join(chaineDecompresse)

def unRLE_ite(input, iteration):
    chaineDecompresse = input
    # Effectuer l'opération unRLE autant de fois que nécessaire
    for _ in range(iteration):
        chaineDecompresse = unRLE(chaineDecompresse)
    return ''.join(chaineDecompresse)


chaineEntree = "abc"

print(RLE(chaineEntree))