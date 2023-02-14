def min_edit_distance(source, target):
    m = len(source)
    n = len(target)
    D = [[0 for i in range(n+1)] for j in range(m+1)] # 2D array of size (m+1)*(n+1), which use to store the min edit distance
    
    for i in range(m+1):
        D[i][0] = i
    
    for j in range(n+1):
        D[0][j] = j
    
    for i in range(1, m+1):
        for j in range(1, n+1):
            if source[i-1] == target[j-1]: # if the last character of source and target are the same
                D[i][j] = D[i-1][j-1] # then the min edit distance is the same as the min edit distance of source[0:i-1] and target[0:j-1]
            else:
                D[i][j] = min(D[i-1][j-1], D[i-1][j], D[i][j-1]) + 1 # otherwise, the min edit distance is the min of the min edit distance of source[0:i-1] and target[0:j-1], source[0:i-1] and target[0:j], source[0:i] and target[0:j-1] plus 1
                
    return D[m][n]

if __name__ == '__main__':
    source = 'intention'
    target = 'execution'
    print(min_edit_distance(source, target))