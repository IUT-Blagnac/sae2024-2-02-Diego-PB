def RLE(in_str):
    """
    Applique l'algorithme de compression RLE (Run Length Encoding) sur une chaîne de caractères.
    
    Args:
        in_str (str): La chaîne de caractères à compresser.

    Returns:
        str: La chaîne compressée.
    """
    # Vérifie si la chaîne d'entrée est vide et retourne une chaîne vide dans ce cas.
    if not in_str:
        return ""
    
    chaine_concat = []  # Liste pour stocker les parties de la chaîne compressée.
    cpt = 1  # Compteur pour le nombre d'occurrences d'un caractère.
    carac_precedent = in_str[0]  # Le premier caractère de la chaîne.

    # Parcourt la chaîne de caractères à partir du deuxième caractère.
    for i in range(1, len(in_str)):
        carac_actuel = in_str[i]
        # Si le caractère actuel est identique au précédent.
        if carac_actuel == carac_precedent:
            if cpt == 9:  # Limite de l'encodage (9 occurrences max pour éviter des chiffres à deux chiffres).
                chaine_concat.append(f"{cpt}{carac_precedent}")
                cpt = 0  # Réinitialise le compteur.
            cpt += 1
        else:
            # Si le caractère actuel est différent du précédent, ajoute la séquence au résultat.
            chaine_concat.append(f"{cpt}{carac_precedent}")
            cpt = 1  # Réinitialise le compteur.
            carac_precedent = carac_actuel  # Met à jour le caractère précédent.

    # Ajoute la dernière séquence au résultat.
    chaine_concat.append(f"{cpt}{carac_precedent}")

    return ''.join(chaine_concat)

def RLE_recursive(in_str, iteration):
    """
    Applique plusieurs itérations de la compression RLE sur une chaîne de caractères.
    
    Args:
        in_str (str): La chaîne de caractères à compresser.
        iteration (int): Le nombre d'itérations à appliquer.

    Returns:
        str: La chaîne compressée après le nombre d'itérations spécifié.
    """
    for _ in range(iteration):
        in_str = RLE(in_str)
    return in_str

def unRLE(in_str):
    """
    Applique l'algorithme de décompression RLE (Run Length Encoding) sur une chaîne de caractères.
    
    Args:
        in_str (str): La chaîne de caractères à décompresser.

    Returns:
        str: La chaîne décompressée.
    """
    # Vérifie si la chaîne d'entrée est vide et retourne une chaîne vide dans ce cas.
    if not in_str:
        return ""
    
    chaine_deconcat = []  # Liste pour stocker les parties de la chaîne décompressée.

    i = 0
    while i < len(in_str):
        # Vérifie si le caractère est un chiffre.
        if in_str[i].isdigit():
            count = int(in_str[i])
            # Vérifie s'il y a un caractère suivant à associer au chiffre.
            if i + 1 < len(in_str):
                character = in_str[i + 1]
                # Ajoute le caractère 'count' fois à la chaîne décompressée.
                chaine_deconcat.extend([character] * count)
                i += 1  # Passe au caractère suivant après le chiffre.
        i += 1

    return ''.join(chaine_deconcat)

def unRLE_recursive(in_str, iteration):
    """
    Applique plusieurs itérations de la décompression RLE sur une chaîne de caractères.
    
    Args:
        in_str (str): La chaîne de caractères à décompresser.
        iteration (int): Le nombre d'itérations à appliquer.

    Returns:
        str: La chaîne décompressée après le nombre d'itérations spécifié.
    """
    for _ in range(iteration):
        in_str = unRLE(in_str)
    return in_str